package org.red.library;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.red.library.entity.player.offline.NewOfflinePlayer;
import org.red.library.event.listener.block.BlockBreakListener;
import org.red.library.event.listener.block.BlockPlaceListener;
import org.red.library.event.listener.entity.EntityDamageByEntityListener;
import org.red.library.event.listener.inventory.InventoryClickListener;
import org.red.library.event.listener.inventory.InventoryCloseListener;
import org.red.library.event.listener.inventory.InventoryOpenListener;
import org.red.library.event.listener.player.*;
import org.red.library.io.config.ConfigFile;
import org.red.library.util.map.DataMap;

import java.io.FileNotFoundException;
import java.io.IOException;

public final class RedKillerLibrary extends JavaPlugin {
    private static RedKillerLibrary plugin;

    public static RedKillerLibrary getPlugin() {
        return RedKillerLibrary.plugin;
    }

    private static boolean debug = true;

    public static void sendLog(Object message) {
        Bukkit.getConsoleSender().sendMessage("§c§l[ RedKillerLibrary ] §f" + message);
    }

    public static void sendDebugLog(Object message) {
        if (debug)
            Bukkit.getConsoleSender().sendMessage("§c§l[ RedKillerLibrary Debug ] §f" + message);
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        RedKillerLibrary.debug = debug;
    }

    private static DataMap dataMap = new DataMap();

    public static DataMap getDataMap() {
        return dataMap;
    }

    @Override
    public void onEnable() {
        RedKillerLibrary.plugin = this;
        this.loadDataMap();
        this.setEvent();
    }

    @Override
    public void onDisable() {
        NewOfflinePlayer.saveAll();
        this.saveDataMap();
    }

    private void loadDataMap() {
        ConfigFile<DataMap> dataMapConfigFile = new ConfigFile<>("dataMap");
        try {
            dataMapConfigFile.read();
            sendLog("Loaded server data");
        } catch (IOException | InvalidConfigurationException e) {
            if (e instanceof FileNotFoundException) {
                RedKillerLibrary.sendDebugLog("§4Failed to load server data (File not found)");
            } else {
                RedKillerLibrary.sendLog("§4Failed to load server data");

                if (RedKillerLibrary.isDebug())
                    e.printStackTrace();
            }
        }
    }

    private void saveDataMap() {
        ConfigFile<DataMap> dataMapConfigFile = new ConfigFile<>("dataMap", dataMap);
        try {
            dataMapConfigFile.write();
            sendLog("Saved server data");
        } catch (IOException e) {
            RedKillerLibrary.sendLog("§4Failed to save server data");
        }
    }

    private void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    private void setEvent() {
        this.registerEvent(new InventoryClickListener());
        this.registerEvent(new InventoryCloseListener());
        this.registerEvent(new InventoryOpenListener());

        this.registerEvent(new EntityDamageByEntityListener());

        this.registerEvent(new PlayerDropItemListener());
        this.registerEvent(new PlayerInteractListener());
        this.registerEvent(new PlayerDropItemListener());
        this.registerEvent(new PlayerFishListener());
        this.registerEvent(new PlayerQuitListener());
        this.registerEvent(new PlayerJoinListener());

        this.registerEvent(new BlockBreakListener());
        this.registerEvent(new BlockPlaceListener());
    }
}
