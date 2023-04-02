package org.red.library.world;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.red.library.util.map.DataMap;
import org.red.library.world.area.Area;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldData {
    private static final Map<World, WorldData> worldDataMap = new HashMap<>();

    public static WorldData getWorldData(World world) {
        return worldDataMap.computeIfAbsent(world, WorldData::new);
    }

    private final World world;
    private final Map<NamespacedKey, Area> areaMap = new HashMap<>();
    private final DataMap dataMap = new DataMap();

    private WorldData(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    public DataMap getDataMap() {
        return dataMap;
    }

    public Map<NamespacedKey, Area> getAreaMap() {
        return areaMap;
    }

    public void registerArea(Area area) {
        areaMap.put(area.getKey(), area);
    }

    public void removeArea(Area area) {
        areaMap.remove(area.getKey());
    }

    public Area getArea(NamespacedKey key) {
        return areaMap.get(key);
    }

    public Area getArea(Plugin plugin, String name) {
        return areaMap.get(new NamespacedKey(plugin, name));
    }

    public List<Area> getAreas(Location location) {
        List<Area> areas = new ArrayList<>();

        for (Area area : areaMap.values()) {
            if (area.contain(location))
                areas.add(area);
        }

        return areas;
    }
}
