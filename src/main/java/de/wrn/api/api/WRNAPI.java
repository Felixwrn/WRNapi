package de.wrn.api.api;

import de.wrn.api.dev.DevModeManager;

public class WRNAPI {

    private static DevModeManager devMode;

    public static void initDevMode(DevModeManager manager) {
        devMode = manager;
    }

    public static DevModeManager getDevMode() {
        return devMode;
    }
}
