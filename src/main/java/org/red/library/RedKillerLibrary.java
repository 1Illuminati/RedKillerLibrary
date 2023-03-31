package org.red.library;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.listener.block.BlockBreakListener;
import org.red.library.event.listener.block.BlockPlaceListener;
import org.red.library.event.listener.inventory.InventoryClickListener;
import org.red.library.event.listener.inventory.InventoryCloseListener;
import org.red.library.event.listener.inventory.InventoryOpenListener;
import org.red.library.event.listener.player.*;
import org.red.library.io.config.ConfigFile;
import org.red.library.io.config.TestFile;

public final class RedKillerLibrary extends JavaPlugin {
    private static RedKillerLibrary plugin;

    public static RedKillerLibrary getPlugin() {
        return RedKillerLibrary.plugin;
    }

    public static void sendLog(Object message) {
        Bukkit.getConsoleSender().sendMessage("§4§l[ RedKillerLibrary ] §f" + message);
    }

    @Override
    public void onEnable() {
        RedKillerLibrary.plugin = this;
        this.setEvent();
        //this.fileTest();
    }

    public void fileTest() {
        TestFile testFile = new TestFile("test", 1, 2L, 1.0, (short) 1, (byte) 1, new ItemStack(Material.AIR), new Location(Bukkit.getWorld("world"), 0, 0, 0));
        ConfigFile<TestFile> configFile = new ConfigFile<>("test", testFile);
        configFile.write();
        ConfigFile<TestFile> configFile2 = new ConfigFile<>("test");
        configFile2.read();
        RedKillerLibrary.sendLog(configFile2.getSerializable().serialize().toString());
    }

    @Override
    public void onDisable() {
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
        this.registerEvent(new PlayerQuitListener());
        this.registerEvent(new PlayerJoinListener());

        this.registerEvent(new BlockBreakListener());
        this.registerEvent(new BlockPlaceListener());
    }
}
