package de.wrn.api;

import de.wrn.api.api.LangAPI;
import de.wrn.api.api.WRNAPI;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class WRNAPIPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        LangAPI langAPI = new LangAPI();
        langAPI.load(new File(getDataFolder(), "lang"));
        WRNAPI.init(langAPI);
        getLogger().info("WRN API geladen!");
    }
}
