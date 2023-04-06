package org.red.library.world.area;

import org.bukkit.*;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.util.BoundingBox;
import org.red.library.item.ban.BanMaterial;

import java.util.HashMap;
import java.util.Map;

public class RedKillerArea implements Area, ConfigurationSerializable {
    private final Map<Material, BanMaterial> banMaterialMap = new HashMap<>();
    private final World world;
    private final BoundingBox boundingBox;
    private final NamespacedKey namespacedKey;
    public RedKillerArea(String name, Location start, Location end) {
        this.world = start.getWorld();

        if (world == null || world != end.getWorld())
            throw new IllegalArgumentException("location world need same");

        this.boundingBox = BoundingBox.of(start, end);
        this.namespacedKey = new NamespacedKey(this.world.getName(), name);
    }
    public RedKillerArea(String name, World world, BoundingBox box) {
        this.world = world;
        this.boundingBox = box;
        this.namespacedKey = new NamespacedKey(this.world.getName(), name);
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
    public void setBanMaterial(BanMaterial banMaterial) {
        banMaterialMap.put(banMaterial.getMaterial(), banMaterial);
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
    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public NamespacedKey getKey() {
        return namespacedKey;
    }

    @Override
    public boolean contain(Location loc) {
        return boundingBox.contains(loc.toVector());
    }

    @Override
    public boolean contain(BoundingBox boundingBox) {
        return boundingBox.contains(boundingBox);
    }

    @Override
    public boolean contain(Area area) {
        return boundingBox.contains(area.getBoundingBox());
    }

    @Override
    public boolean overlap(Area area) {
        return boundingBox.overlaps(area.getBoundingBox());
    }

    @Override
    public boolean overlap(BoundingBox boundingBox) {
        return boundingBox.overlaps(boundingBox);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("box", this.boundingBox);
        map.put("world", this.world.getName());
        map.put("ban_material", this.banMaterialMap);
        map.put("name", this.namespacedKey.getKey());
        return map;
    }

    public RedKillerArea deserialize(Map<String, Object> map) {
        return new RedKillerArea((String) map.get("name"), Bukkit.getWorld((String) map.get("world")), (BoundingBox) map.get("box"));
    }
}
