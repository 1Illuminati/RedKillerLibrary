package org.red.library.event.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.WorldData;
import org.red.library.world.area.Area;

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

    protected void runAreaEvent(AreaEvent areaEvent) {
        Bukkit.getPluginManager().callEvent(areaEvent);
        //areaEvent.getLogger().info(areaEvent.log());
    }
}
