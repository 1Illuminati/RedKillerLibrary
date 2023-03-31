package org.red.library.io.config;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class TestFile implements ConfigurationSerializable {
    private final String name;
    private final int age;
    private final long height;
    private final double weight;
    private final short age2;
    private final byte age3;
    private final ItemStack hand;
    private final Location loc;

    public TestFile(String name, int age, long height, double weight, short age2, byte age3, ItemStack hand, Location loc) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.age2 = age2;
        this.age3 = age3;
        this.hand = hand;
        this.loc = loc;
    }

    public static TestFile deserialize(Map<String, Object> map) {
        return new TestFile((String) map.get("name"), (int) map.get("age"), (long) map.get("height"), (double) map.get("weight"), (short) 3,
                (byte) 3, (ItemStack) map.get("hand"), (Location) map.get("loc"));
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("age", this.age);
        map.put("height", this.height);
        map.put("weight", this.weight);
        map.put("age2", this.age2);
        map.put("age3", this.age3);
        map.put("hand", this.hand);
        map.put("loc", this.loc);
        return map;
    }
}
