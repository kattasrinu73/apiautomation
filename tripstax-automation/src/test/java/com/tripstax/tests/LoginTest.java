package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import com.tripstax.pages.DashboardPage;
import com.tripstax.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Login with valid credentials and verify dashboard is accessible")
    public void loginShouldSucceed() {
        String baseUrl = config.getProperty("baseUrl");
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        LoginPage loginPage = loginPage().open(baseUrl)
            .typeEmail(username)
            .typePassword(password);

        loginPage.submit();

        DashboardPage dashboard = dashboardPage();
        boolean loggedIn = dashboard.isLoggedIn();

        Assert.assertTrue(loggedIn, "Expected to be logged in, but login markers are still present or URL indicates login page.");
    }
}