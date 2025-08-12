package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(description = "Primary navigation menu renders", enabled = false)
    public void primaryNavigationVisible() {
        throw new SkipException("Enable after mapping nav container selector (aside/nav)");
    }

    @Test(description = "Navigate to each main module", enabled = false)
    public void navigateToModules() {
        throw new SkipException("Enable after identifying menu item locators");
    }
}