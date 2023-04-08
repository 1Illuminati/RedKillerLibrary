package org.red.library.world;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.plugin.Plugin;
import org.red.library.RedKillerLibrary;
import org.red.library.io.config.ConfigFile;
import org.red.library.item.ban.BanMaterial;
import org.red.library.item.ban.HasBanMaterial;
import org.red.library.util.map.DataMap;
import org.red.library.world.area.Area;
import org.red.library.world.rule.HasRGameRule;
import org.red.library.world.rule.RGameRule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldData implements HasBanMaterial, ConfigurationSerializable, HasRGameRule {
    private static final Map<World, WorldData> worldDataMap = new HashMap<>();

    public static WorldData getWorldData(World world) {
        return worldDataMap.computeIfAbsent(world, k -> {
            WorldData worldData = new WorldData(world);
            worldData.load();
            return worldData;
        });
    }

    public static void saveAll() {
        for (WorldData worldData : worldDataMap.values()) {
            worldData.save();
        }
    }

    private final World world;
    private final Map<NamespacedKey, Area> areaMap = new HashMap<>();
    private final DataMap dataMap = new DataMap();
    private final Map<Material, BanMaterial> banMaterialMap = new HashMap<>();
    private final Map<String, Object> gameRuleMap = new HashMap<>();

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
            if (location.getWorld() != world)
                continue;

            if (area.contain(location))
                areas.add(area);
        }

        return areas;
    }

    public List<Area> getAreas(Location... locations) {
        List<Area> areas = new ArrayList<>();

        for (Area area : areaMap.values()) {
            for (Location location : locations) {
                if (location.getWorld() != world || !area.contain(location))
                    continue;

                areas.add(area);
                break;
            }
        }

        return areas;
    }


    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("world", this.world.getName());
        map.put("data", this.dataMap);
        map.put("ban_material", this.banMaterialMap);
        map.put("game_rule", this.gameRuleMap);
        return map;
    }

    public WorldData deserialize(Map<String, Object> map) {
        World world = org.bukkit.Bukkit.getWorld((String) map.get("world"));
        WorldData worldData = new WorldData(world);
        worldData.dataMap.copy((DataMap) map.get("data"));
        worldData.banMaterialMap.putAll((Map<Material, BanMaterial>) map.get("ban_material"));
        worldData.gameRuleMap.putAll((Map<String, Object>) map.get("game_rule"));
        return worldData;
    }

    @Override
    public BanMaterial getBanMaterial(Material material) {
        return banMaterialMap.get(material);
    }

    @Override
    public boolean hasBanMaterial(Material material) {
        return banMaterialMap.containsKey(material);
    }

    @Override
    public void registerBanMaterial(BanMaterial banMaterial) {
        banMaterialMap.put(banMaterial.getMaterial(), banMaterial);
    }

    @Override
    public List<BanMaterial> banMaterials() {
        return new ArrayList<>(this.banMaterialMap.values());
    }

    @Override
    public boolean isAllow(Material material, BanMaterial.Act act) {
        if (!this.hasBanMaterial(material)) {
            return true;
        }

        BanMaterial banMaterial = this.getBanMaterial(material);
        return banMaterial.getAllow(act);
    }

    @Override
    public <T> T getRGameRuleValue(RGameRule<T> rule) {
        return (T) this.gameRuleMap.computeIfAbsent(rule.getKey(), k -> rule.getDefaultValue());
    }

    @Override
    public <T> void setRGameRuleValue(RGameRule<T> rule, T value) {
        this.gameRuleMap.put(rule.getKey(), value);
    }

    public void load() {
        ConfigFile<WorldData> configFile = new ConfigFile<>("world/" + world.getName());

        try {
            configFile.read();
            WorldData worldData = configFile.getSerializable();
            this.dataMap.copy(worldData.dataMap);
            this.banMaterialMap.putAll(worldData.banMaterialMap);
            this.gameRuleMap.putAll(worldData.gameRuleMap);
        } catch (IOException | InvalidConfigurationException e) {
            if (e instanceof FileNotFoundException) {
                RedKillerLibrary.sendDebugLog("§4Failed to load world data: " + world.getName() + " (File not found)");
            } else {
                RedKillerLibrary.sendLog("§4Failed to load world data: " + world.getName());

                if (RedKillerLibrary.isDebug())
                    e.printStackTrace();
            }
        }
    }

    public void save() {
        ConfigFile<WorldData> configFile = new ConfigFile<>("world/" + world.getName(), this);

        try {
            configFile.write();
        } catch (IOException e) {
            RedKillerLibrary.sendLog("§4Failed to save world data: " + world.getName());

            if (RedKillerLibrary.isDebug())
                e.printStackTrace();
        }
    }
}
