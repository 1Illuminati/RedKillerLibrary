package org.red.library;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.red.library.event.listener.block.BlockBreakListener;
import org.red.library.event.listener.block.BlockPlaceListener;
import org.red.library.event.listener.inventory.InventoryClickListener;
import org.red.library.event.listener.inventory.InventoryCloseListener;
import org.red.library.event.listener.inventory.InventoryOpenListener;
import org.red.library.event.listener.player.PlayerDropItemListener;
import org.red.library.event.listener.player.PlayerFishListener;
import org.red.library.event.listener.player.PlayerInteractListener;

public final class RedKillerLibrary extends JavaPlugin {
    private static RedKillerLibrary plugin;

    public static RedKillerLibrary getPlugin() {
        return RedKillerLibrary.plugin;
    }

    public static void sendLog(Object message) {
        Bukkit.getConsoleSender().sendMessage("" + message);
    }

    @Override
    public void onEnable() {
        RedKillerLibrary.plugin = this;
        this.setEvent();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    private void setEvent() {
        this.registerEvent(new InventoryClickListener());
        this.registerEvent(new InventoryCloseListener());
        this.registerEvent(new InventoryOpenListener());

        this.registerEvent(new PlayerDropItemListener());
        this.registerEvent(new PlayerInteractListener());
        this.registerEvent(new PlayerDropItemListener());
        this.registerEvent(new PlayerFishListener());

        this.registerEvent(new BlockBreakListener());
        this.registerEvent(new BlockPlaceListener());
    }
}
