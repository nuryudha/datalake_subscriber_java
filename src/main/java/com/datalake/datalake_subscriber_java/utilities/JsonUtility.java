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
        return 0L;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getNestedMap(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        }
        Object value = map.get(key);
        return value instanceof Map ? (Map<String, Object>) value : null;
    }

    public Map<String, Object> getNestedNestedMap(Map<String, Object> map,
            Map<String, Object> mapNested) {
        int jumlahNested = Integer.parseInt(mapNested.get("jumlahNested").toString());
        Map<String, Object> currentMap = map;
        for (int i = 1; i <= jumlahNested; i++) {
            String key = mapNested.get("keyNested_" + i).toString();
            currentMap = getNestedMap(currentMap, key);
            if (currentMap == null) {
                return null;
            }
        }
        return currentMap;
    }

}
