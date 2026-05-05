package de.wrn.api.dev;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class DevModeManager {

    private boolean enabled;
    private final Set<String> confirmed = new HashSet<>();
    private final Map<UUID, Integer> steps = new HashMap<>();

    public DevModeManager(boolean enabled, List<String> confirmedList) {
        this.enabled = enabled;
        confirmed.addAll(confirmedList);
    }

    public boolean isEnabled() { return enabled; }

    public void toggle() { enabled = !enabled; }

    public boolean isConfirmed(String plugin) {
        return confirmed.contains(plugin.toLowerCase());
    }

    public boolean handleConfirm(UUID uuid, String plugin) {
        int step = steps.getOrDefault(uuid, 0) + 1;

        if (step < 3) {
            steps.put(uuid, step);
            return false;
        }

        confirmed.add(plugin.toLowerCase());
        steps.remove(uuid);
        return true;
    }

    public void checkPlugins() {
        if (!enabled) return;

        for (Plugin p : Bukkit.getPluginManager().getPlugins()) {

            if (p.getName().equalsIgnoreCase("WRN-API")) continue;

            String api = p.getDescription().getAPIVersion();
            boolean compatible = api != null && api.startsWith("1.21");

            if (!compatible && !isConfirmed(p.getName())) {
                Bukkit.getLogger().warning("Disabled: " + p.getName());
                Bukkit.getPluginManager().disablePlugin(p);
            }
        }
    }
}
