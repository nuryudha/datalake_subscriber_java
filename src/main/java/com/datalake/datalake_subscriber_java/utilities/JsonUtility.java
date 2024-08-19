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

    // public String getLongValue(Map<String, Object> map, String key) {
    // if (map != null && map.containsKey(key)) {
    // Object value = map.get(key);
    // if (value instanceof Long) {
    // return (Long) value;
    // } else if (value instanceof Number) {
    // return ((Number) value).longValue();
    // }
    // }
    // return 0L;
    // }

    public String getLongValue(Map<String, Object> map, String key) {
        if (map != null && map.containsKey(key)) {
            Object value = map.get(key);
            if (value instanceof Long) {
                return value.toString(); // Mengembalikan Long sebagai String
            } else if (value instanceof Number) {
                return Long.toString(((Number) value).longValue()); // Mengonversi Number ke String
            }
        }
        return null; // Mengembalikan null jika tidak ditemukan
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

    public String regexCleaner(String custAddress) {
        // Mengganti karakter carriage return (\r), line feed (\n), dan tab (\t) dengan
        // string kosong
        return custAddress.replaceAll("[\r\n\t]", "");
    }

    // Helper method untuk mengonversi String ke Long, mengembalikan null jika gagal
    public Long parseLongOrNull(String value) {
        if (value != null && !value.trim().isEmpty()) {
            try {
                return Long.valueOf(value);
            } catch (NumberFormatException e) {
                // Log exception jika perlu
            }
        }
        return null;
    }

}
