package com.tripstax.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private static final By GENERIC_LOGOUT = By.xpath("//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'logout') or contains(@aria-label,'logout')]");
    private static final By GENERIC_PROFILE = By.xpath("//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'profile') or contains(@aria-label,'profile') or contains(@data-testid,'profile')]");

    public DashboardPage(WebDriver driver, Duration explicitWait) {
        super(driver, explicitWait);
    }

    public boolean isLoggedIn() {
        try {
            waitUntilVisible(GENERIC_LOGOUT);
            return true;
        } catch (Exception ignored) {}
        try {
            waitUntilVisible(GENERIC_PROFILE);
            return true;
        } catch (Exception ignored) {}
        return !isOnLoginLikeUrl();
    }

    private boolean isOnLoginLikeUrl() {
        String url = driver.getCurrentUrl();
        String lower = url == null ? "" : url.toLowerCase();
        return lower.contains("login") || lower.contains("signin");
    }
}