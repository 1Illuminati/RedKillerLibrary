package org.red.library.entity.player.offline;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.red.library.io.config.ConfigFile;
import org.red.library.util.map.CoolTime;
import org.red.library.util.map.DataMap;

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
    }

    public static void loadAll() {
        for (NewOfflinePlayer newOfflinePlayer : newOfflinePlayerMap.values()) {
            newOfflinePlayer.load();
        }
    }

    private final DataMap dataMap = new DataMap();
    private final CoolTime coolTime = new CoolTime();
    protected NewOfflinePlayer(OfflinePlayer offlinePlayer) {
        super(offlinePlayer);
    }

    public DataMap getDataMap() {
        return dataMap;
    }

    public CoolTime getCoolTime() {
        return coolTime;
    }

    public void save() {
        ConfigFile<NewOfflinePlayer> offlinePlayerConfigFile = new ConfigFile<>("player/" + super.getUniqueId(), this);
        offlinePlayerConfigFile.write();
    }

    public void load() {
        ConfigFile<NewOfflinePlayer> offlinePlayerConfigFile = new ConfigFile<>("player/" + super.getUniqueId());
        offlinePlayerConfigFile.read();
        NewOfflinePlayer offlinePlayer = offlinePlayerConfigFile.getSerializable();

        if (offlinePlayer.getUniqueId() != super.getUniqueId())
            throw new IllegalArgumentException("The UUID of the offline player is not the same as the UUID of the player being loaded.");

        this.coolTime.copy(offlinePlayer.getCoolTime());
        this.dataMap.copy(offlinePlayer.getDataMap());
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("dataMap", dataMap);
        map.put("coolTime", coolTime);
        map.put("uuid", super.getUniqueId().toString());

        return map;
    }

    public static NewOfflinePlayer deserialize(Map<String, Object> map) {
        UUID uuid = UUID.fromString(map.get("uuid").toString());
        NewOfflinePlayer offlinePlayer = new NewOfflinePlayer(Bukkit.getPlayer(uuid));
        offlinePlayer.dataMap.copy((DataMap) map.get("dataMap"));
        offlinePlayer.coolTime.copy((CoolTime) map.get("coolTime"));
        return offlinePlayer;
    }
}
