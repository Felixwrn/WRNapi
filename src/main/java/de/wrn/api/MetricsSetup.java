package de.wrn.api;

import org.bstats.bukkit.Metrics;

public class MetricsSetup {

    public static void init(JavaPlugin plugin) {
        int pluginId = 12345; // replace with your bStats ID
        Metrics metrics = new Metrics(plugin, pluginId);
    }
}
