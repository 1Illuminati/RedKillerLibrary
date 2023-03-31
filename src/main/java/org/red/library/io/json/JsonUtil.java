package org.red.library.io.json;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.red.library.util.map.DataMap;

import java.util.*;

public class JsonUtil {
    public static Map<String, Object> objToMap(Object object) {
        Map<String, Object> result = new HashMap<>();
        int classNumber = -1;
        Object obj = object;
        if (object instanceof String)
            classNumber = 0;
        else if (object instanceof Integer)
            classNumber = 1;
        else if (object instanceof Float)
            classNumber = 2;
        else if (object instanceof Double)
            classNumber = 3;
        else if (object instanceof Long)
            classNumber = 4;
        else if (object instanceof Short)
            classNumber = 5;
        else if (object instanceof Byte)
            classNumber = 6;
        else if (object instanceof Boolean)
            classNumber = 7;
        else if (object instanceof Character)
            classNumber = 8;
        else if (object instanceof Map<?, ?> value) {
            classNumber = 9;
            Map<String, Object> map = new HashMap<>();

            for (Map.Entry<?, ?> entry : value.entrySet()) {
                if (entry.getKey() instanceof String key)
                    map.put(key, objToMap(entry.getValue()));
            }

            obj = map;
        } else if (object instanceof List<?> value) {
            classNumber = 10;
            List<Map<String, Object>> list = new ArrayList<>();

            for (Object o : value)
                list.add(objToMap(o));

            obj = list;
        } else if (obj instanceof DataMap value) {
            classNumber = 11;
            Map<String, Object> map = new HashMap<>();

            for (String key : value.keySet()) {
                map.put(key, objToMap(value.get(key)));
            }

            obj = map;
        } else if (obj instanceof ConfigurationSerializable value) {
            classNumber = 12;
            result.put("serializable", value.getClass().getName());
            obj = value.serialize();
        }else if (obj instanceof UUID value) {
            classNumber = 13;
            obj = value.toString();
        } else
            throw new IllegalArgumentException("The object is not a primitive, array, or map. (" + object.getClass().getName() + ")");

        result.put("class", classNumber);
        result.put("value", obj);

        return result;
    }

    public static Object mapToObj(Map<String, Object> map) {
        int classNumber = (int) map.get("class");
        Object obj = map.get("value");return null;
    }

}
