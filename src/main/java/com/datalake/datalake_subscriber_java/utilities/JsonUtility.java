package com.datalake.datalake_subscriber_java.utilities;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class JsonUtility {

    @SuppressWarnings("unchecked")
    public Map<String, Object> parseMessage(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message, Map.class);
    }

    public String getStringValue(Map<String, Object> map, String key) {
        return map != null ? (String) map.getOrDefault(key, "") : "";

    }

    public Long getLongValue(Map<String, Object> map, String key) {
        if (map != null && map.containsKey(key)) {
            Object value = map.get(key);
            if (value instanceof Long) {
                return (Long) value;
            } else if (value instanceof Number) {
                return ((Number) value).longValue();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getNestedMap(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        }
        Object value = map.get(key);
        return value instanceof Map ? (Map<String, Object>) value : null;
    }

    public String getNestedNestedMap(Map<String, Object> map, Map<String, Object> mapNested) {
        int jumlahNested = Integer.parseInt(mapNested.get("jumlahNested").toString());
        String[] keys = {
                mapNested.get("keyNested_1").toString(),
                mapNested.get("keyNested_2").toString(),
                mapNested.get("keyNested_3").toString(),
                mapNested.get("keyNested_4").toString(),
                mapNested.get("keyNested_5").toString()
        };

        Map<String, Object> currentMap = map;
        String result = "";

        for (int i = 0; i < jumlahNested; i++) {
            currentMap = getNestedMap(currentMap, keys[i]);
            if (currentMap == null) {
                return null;
            }
        }

        return result;
    }

}
