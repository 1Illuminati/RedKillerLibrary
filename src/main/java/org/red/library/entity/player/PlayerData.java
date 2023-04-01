package org.red.library.entity.player;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.red.library.util.map.CoolTime;
import org.red.library.util.map.DataMap;

import java.util.HashMap;
import java.util.Map;

public record PlayerData(DataMap dataMap, CoolTime coolTime) implements ConfigurationSerializable {

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("dataMap", this.dataMap);
        map.put("coolTime", this.coolTime);

        return map;
    }

    public static PlayerData deserialize(Map<String, Object> map) {
        DataMap dataMap = (DataMap) map.get("dataMap");
        CoolTime coolTime = (CoolTime) map.get("coolTime");
        return new PlayerData(dataMap, coolTime);
    }
}
