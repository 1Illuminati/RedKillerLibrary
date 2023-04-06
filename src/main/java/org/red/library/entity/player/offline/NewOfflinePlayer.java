package org.red.library.entity.player.offline;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.red.library.RedKillerLibrary;
import org.red.library.entity.player.PlayerData;
import org.red.library.io.config.ConfigFile;
import org.red.library.util.map.CoolTime;
import org.red.library.util.map.DataMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NewOfflinePlayer extends OfflinePlayerObj {
    private static final Map<UUID, NewOfflinePlayer> newOfflinePlayerMap = new HashMap<>();

    public static NewOfflinePlayer getNewOfflinePlayer(UUID playerUUID) {
        return NewOfflinePlayer.getNewOfflinePlayer(Bukkit.getOfflinePlayer(playerUUID));
    }

    public static NewOfflinePlayer getNewOfflinePlayer(OfflinePlayer offlinePlayer) {
        if (!newOfflinePlayerMap.containsKey(offlinePlayer.getUniqueId()))
            newOfflinePlayerMap.put(offlinePlayer.getUniqueId(), new NewOfflinePlayer(offlinePlayer));

        return newOfflinePlayerMap.get(offlinePlayer.getUniqueId());
    }

    public static void saveAll() {
        for (NewOfflinePlayer newOfflinePlayer : newOfflinePlayerMap.values()) {
            newOfflinePlayer.save();
        }

        RedKillerLibrary.sendLog("Saved all player data");
    }

    public static void loadAll() {
        for (NewOfflinePlayer newOfflinePlayer : newOfflinePlayerMap.values()) {
            newOfflinePlayer.load();
        }

        RedKillerLibrary.sendLog("Loaded all player data");
    }

    private final DataMap dataMap = new DataMap();
    private final CoolTime coolTime = new CoolTime();
    protected NewOfflinePlayer(OfflinePlayer offlinePlayer) {
        super(offlinePlayer);
        this.load();
    }

    public DataMap getDataMap() {
        return dataMap;
    }

    public CoolTime getCoolTime() {
        return coolTime;
    }

    public void save() {
        ConfigFile<PlayerData> dataConfigFile = new ConfigFile<>("player/" + super.getUniqueId(), new PlayerData(getDataMap(), getCoolTime()));
        try {
            dataConfigFile.write();
            RedKillerLibrary.sendLog("Saved player data: " + super.getUniqueId());
        } catch (IOException e) {
            RedKillerLibrary.sendLog("§4Failed to save player data: " + super.getUniqueId());

            if (RedKillerLibrary.isDebug())
                e.printStackTrace();
        }
    }

    public void load() {
        ConfigFile<PlayerData> dataConfigFile = new ConfigFile<>("player/" + super.getUniqueId());
        try {
            dataConfigFile.read();
            PlayerData playerData = dataConfigFile.getSerializable();

            this.coolTime.copy(playerData.coolTime());
            this.dataMap.copy(playerData.dataMap());

            RedKillerLibrary.sendLog("Loaded player data: " + super.getUniqueId());
        } catch (IOException | InvalidConfigurationException e) {
            if (e instanceof FileNotFoundException) {
                RedKillerLibrary.sendDebugLog("§4Failed to load player data: " + super.getUniqueId() + " (File not found)");
            } else {
                RedKillerLibrary.sendLog("§4Failed to load player data: " + super.getUniqueId());

                if (RedKillerLibrary.isDebug())
                    e.printStackTrace();
            }
        }
    }
}
