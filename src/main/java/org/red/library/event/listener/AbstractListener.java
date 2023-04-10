package org.red.library.event.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.WorldData;
import org.red.library.world.area.Area;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class AbstractListener implements Listener {
    protected List<Area> getAreas(Location location) {
        World world = location.getWorld();

        if (world == null)
            throw new NullPointerException("World is null");

        WorldData worldData = WorldData.getWorldData(world);
        return worldData.getAreas(location);
    }

    protected List<Area> getAreas(World world, Location... locations) {
        WorldData worldData = WorldData.getWorldData(world);
        return worldData.getAreas(locations);
    }

    protected void runPlayerAreaEvent(PlayerEvent playerEvent, Class<? extends AreaEvent> clazz) {
        this.runAreaEvent(playerEvent.getPlayer().getLocation(), playerEvent, clazz);
    }

    protected void runBlockAreaEvent(BlockEvent blockEvent, Class<? extends AreaEvent> clazz) {
        this.runAreaEvent(blockEvent.getBlock().getLocation(), blockEvent, clazz);
    }

    protected void runEntityAreaEvent(EntityEvent entityEvent, Class<? extends AreaEvent> clazz) {
        this.runAreaEvent(entityEvent.getEntity().getLocation(), entityEvent, clazz);
    }

    protected void runAreaEvent(Location location, Event event, Class<? extends AreaEvent> clazz) {
        for (Area area : getAreas(location)) {
            try {
                AreaEvent areaEvent = clazz.getConstructor(Area.class, event.getClass()).newInstance(area, event);
                Bukkit.getPluginManager().callEvent(areaEvent);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
