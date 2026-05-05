package de.wrn.api;

import de.wrn.api.api.WRNAPI;
import de.wrn.api.dev.DevModeManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WRNAPIPlugin extends JavaPlugin {

    private DevModeManager dev;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        dev = new DevModeManager(
                getConfig().getBoolean("dev-mode.enabled"),
                getConfig().getStringList("dev-mode.confirmed-plugins")
        );

        WRNAPI.initDevMode(dev);

        dev.checkPlugins();

        getLogger().info("WRN API loaded!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player p)) return true;

        if (cmd.getName().equalsIgnoreCase("wrn")) {

            if (args.length == 0) {
                p.sendMessage("/wrn devmode | confirm <plugin>");
                return true;
            }

            if (args[0].equalsIgnoreCase("devmode")) {
                dev.toggle();
                p.sendMessage("DevMode: " + dev.isEnabled());
                return true;
            }

            if (args[0].equalsIgnoreCase("confirm") && args.length == 2) {

                if (!dev.handleConfirm(p.getUniqueId(), args[1])) {
                    p.sendMessage("WARNING confirm again!");
                    return true;
                }

                p.sendMessage("Plugin unlocked: " + args[1]);
                return true;
            }
        }

        return true;
    }
}
