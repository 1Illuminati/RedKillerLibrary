package org.red.library.item.ban;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class BanMaterial implements ConfigurationSerializable {
    private final Material material;
    private final Map<Act, Boolean> map;

    public BanMaterial(Material material, Map<Act, Boolean> map) {
        this.material = material;
        this.map = map;
    }

    public BanMaterial(Material material) {
        this(material, new HashMap<>());
    }

    public Material getMaterial() {
        return material;
    }

    public boolean getAllow(Act act) {
        return map.computeIfAbsent(act, k -> true);
    }

    public void setAllow(Act act, boolean allow) {
        map.put(act, allow);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("material", material.name());
        for (Act act : Act.values()) {
            map.put(act.name(), getAllow(act));
        }

        return map;
    }

    public static BanMaterial deserialize(Map<String, Object> map) {
        Material material = Material.valueOf((String) map.get("material"));
        Map<Act, Boolean> actMap = new HashMap<>();
        for (Act act : Act.values()) {
            actMap.put(act, (Boolean) map.getOrDefault(act.name(), true));
        }

        return new BanMaterial(material, actMap);
    }

    public enum Act {
        PICK_UP,
        DROP,
        PLACE,
        BREAK,
        CLICK,
        INV_CLICK,
        CRAFT
    }
}
