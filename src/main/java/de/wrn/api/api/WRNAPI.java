package de.wrn.api.api;

import java.util.Map;
import java.util.UUID;

public class WRNAPI {

    private static LangAPI langAPI;

    public static void init(LangAPI lang) {
        langAPI = lang;
    }

    public static String text(UUID uuid, String key) {
        return langAPI.get(uuid, key);
    }

    public static String text(UUID uuid, String key, Map<String, String> placeholders) {
        return langAPI.replace(uuid, key, placeholders);
    }

    public static void setLanguage(UUID uuid, String lang) {
        langAPI.setLanguage(uuid, lang);
    }
}
