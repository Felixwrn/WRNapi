package de.wrn.api.dev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DevModeManagerTest {
    @Test
    void keepsPreviouslySupportedMinecraft121PluginsEnabled() {
        assertTrue(DevModeManager.isSupportedApiVersion("1.21"));
        assertTrue(DevModeManager.isSupportedApiVersion("1.21.8"));
    }

    @Test
    void keepsMinecraft263PluginsEnabled() {
        assertTrue(DevModeManager.isSupportedApiVersion("26.3"));
        assertTrue(DevModeManager.isSupportedApiVersion("26.3.1"));
    }

    @Test
    void rejectsMissingAndOtherApiVersions() {
        assertFalse(DevModeManager.isSupportedApiVersion(null));
        assertFalse(DevModeManager.isSupportedApiVersion("1.20"));
        assertFalse(DevModeManager.isSupportedApiVersion("1.22"));
        assertFalse(DevModeManager.isSupportedApiVersion("26.2"));
    }

    @Test
    void rejectsVersionsThatOnlyShareThePrefix() {
        assertFalse(DevModeManager.isSupportedApiVersion("1.210"));
        assertFalse(DevModeManager.isSupportedApiVersion("26.30"));
    }
}
