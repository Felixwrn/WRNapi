package de.wrn.api.api;

import java.util.HashMap;

public class PlaceholderAPI {

    public static HashMap<String, String> create() {
        return new HashMap<>();
    }

    public static HashMap<String, String> add(HashMap<String, String> map, String key, String value) {
        map.put(key, value);
        return map;
    }
}
