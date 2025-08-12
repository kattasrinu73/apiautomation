package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import com.tripstax.pages.DashboardPage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {

    @Test(description = "Valid login redirects to dashboard", enabled = true)
    public void validLogin() {
        String baseUrl = config.getProperty("baseUrl");
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        dashboardPage(); // initialize wait
        driver.get(baseUrl);
        new com.tripstax.pages.LoginPage(driver, explicitWait())
            .typeEmail(username)
            .typePassword(password)
            .submit();

        Assert.assertTrue(dashboardPage().isLoggedIn(), "Expected to be logged in.");
    }

    @Test(description = "Invalid password shows error", enabled = false)
    public void invalidPasswordShowsError() {
        throw new SkipException("Enable after mapping login error selector");
    }

    @Test(description = "Empty fields show required validation", enabled = false)
    public void requiredFieldsValidation() {
        throw new SkipException("Enable after mapping field error selectors");
    }

    @Test(description = "Logout ends session and protects routes", enabled = false)
    public void logoutAndRouteProtection() {
        throw new SkipException("Enable after mapping user menu + logout");
    }
}