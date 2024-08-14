package com.datalake.datalake_subscriber_java.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class JsonParserUtility {

    @SuppressWarnings("unchecked")
    public Map<String, Object> parseMessage(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message, Map.class);
    }

    // Untuk mengambil data yang bersarang (SUPERPOWER)
    @SuppressWarnings("unchecked")
    public Map<String, Object> getNestedMap(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        }
        Object value = map.get(key);
        return value instanceof Map ? (Map<String, Object>) value : null;
    }

    // Untuk Mendeclare data tersebut jadi STRING dan mengatasi data yang null atau
    // kosong
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

}
