package org.red.library.entity.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.red.library.entity.player.npc.NpcPlayer;
import org.red.library.entity.player.offline.NewOfflinePlayer;
import org.red.library.util.async.Scheduler;
import org.red.library.util.map.CoolTime;
import org.red.library.util.map.DataMap;

import java.util.HashMap;
import java.util.UUID;

public class NewPlayer extends PlayerObj {
    private static final HashMap<UUID, NewPlayer> newPlayerMap = new HashMap<>();
    private static final UUID redKillerAccount1 = UUID.fromString("a9f022ea-c7b0-4b13-8543-e6ed24e8396f");
    private static final UUID redKillerAccount2 = UUID.fromString("697c7e70-8863-4595-bc3a-cd190af795d2");

    public static NewPlayer getNewPlayer(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);

        if (player == null)
            return null;

        return NewPlayer.getNewPlayer(player);
    }

    public static NewPlayer getNewPlayer(String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player == null)
            return null;

        return NewPlayer.getNewPlayer(player);
    }

    public static NewPlayer getNewPlayer(Player player) {
        if (player.hasMetadata("NPC")) {
            return NpcPlayer.getNPCPlayer(player);
        }

        if (!newPlayerMap.containsKey(player.getUniqueId()))
            newPlayerMap.put(player.getUniqueId(), new NewPlayer(player));
        else if (!newPlayerMap.get(player.getUniqueId()).getPlayer().equals(player))
            newPlayerMap.put(player.getUniqueId(), new NewPlayer(player));

        return newPlayerMap.get(player.getUniqueId());
    }
    private final NewOfflinePlayer offlinePlayer;
    private final DataMap dataMap;
    private final CoolTime coolTime;
    private final boolean redKiller;
    private boolean ignoreCloseEvent = false;
    protected NewPlayer(Player player) {
        super(player);
        UUID uuid = player.getUniqueId();
        this.offlinePlayer = NewOfflinePlayer.getNewOfflinePlayer(uuid);
        this.dataMap = offlinePlayer.getDataMap();
        this.coolTime = offlinePlayer.getCoolTime();
        this.redKiller = uuid.equals(redKillerAccount1) || uuid.equals(redKillerAccount2);
    }

    public void delayOpenInventory(Inventory inv) {
        this.delayOpenInventory(inv, false);
    }

    public void delayOpenInventory(Inventory inv, boolean ignoreCloseEvent) {
        Scheduler.delayScheduler(new Scheduler.RunnableEx() {
            @Override
            public void function() {
                openInventory(inv);

                if (ignoreCloseEvent)
                    setIgnoreCloseEvent(true);
            }
        }, 2);
    }

    public void load() {
        offlinePlayer.load();
    }

    public void save() {
        offlinePlayer.save();
    }

    public boolean isIgnoreCloseEvent() {
        return ignoreCloseEvent;
    }

    public void setIgnoreCloseEvent(boolean ignoreCloseEvent) {
        this.ignoreCloseEvent = ignoreCloseEvent;
    }

    public NewOfflinePlayer getOfflinePlayer() {
        return offlinePlayer;
    }

    public DataMap getDataMap() {
        return dataMap;
    }

    public CoolTime getCoolTime() {
        return coolTime;
    }

    public boolean isRedKiller() {
        return redKiller;
    }
}
