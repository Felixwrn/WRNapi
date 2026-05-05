package de.wrn.api.api;

import java.io.File;
import java.util.*;

public class LangAPI {

    private final HashMap<String, HashMap<String, String>> languages = new HashMap<>();
    private final HashMap<UUID, String> playerLang = new HashMap<>();

    public void load(File folder) {
        if (!folder.exists()) folder.mkdirs();
    }

    public void setLanguage(UUID uuid, String lang) {
        playerLang.put(uuid, lang);
    }

    public String get(UUID uuid, String key) {
        return key;
    }

    public String replace(UUID uuid, String key, Map<String, String> placeholders) {
        String text = key;
        for (String k : placeholders.keySet()) {
            text = text.replace("{" + k + "}", placeholders.get(k));
        }
        return text;
    }
}
