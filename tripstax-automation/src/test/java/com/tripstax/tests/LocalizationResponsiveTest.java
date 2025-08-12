package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.openqa.selenium.Dimension;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LocalizationResponsiveTest extends BaseTest {

    @Test(description = "Responsive layout common breakpoints", enabled = false)
    public void responsiveLayout() {
        throw new SkipException("Enable once critical pages are identified");
    }

    @Test(description = "Localization toggles language", enabled = false)
    public void localizationLanguage() {
        throw new SkipException("Enable after mapping language switcher");
    }
}