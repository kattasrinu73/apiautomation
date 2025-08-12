package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SettingsPreferencesTest extends BaseTest {

    @Test(description = "Update profile details persists", enabled = false)
    public void updateProfile() {
        throw new SkipException("Enable after mapping profile form");
    }

    @Test(description = "Toggle notification preferences", enabled = false)
    public void toggleNotifications() {
        throw new SkipException("Enable after mapping notification toggles");
    }
}