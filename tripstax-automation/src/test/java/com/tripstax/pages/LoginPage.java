package com.tripstax.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final List<By> EMAIL_LOCATORS = Arrays.asList(
        By.id("email"),
        By.name("email"),
        By.cssSelector("input[type='email']"),
        By.cssSelector("input[name='username']"),
        By.cssSelector("input#username")
    );

    private static final List<By> PASSWORD_LOCATORS = Arrays.asList(
        By.id("password"),
        By.name("password"),
        By.cssSelector("input[type='password']")
    );

    private static final List<By> SUBMIT_LOCATORS = Arrays.asList(
        By.cssSelector("button[type='submit']"),
        By.xpath("//button[contains(., 'Log in') or contains(., 'Login') or contains(., 'Sign in') or contains(., 'Sign In')]"),
        By.xpath("//input[@type='submit' or @value='Login' or @value='Log in' or @value='Sign in']")
    );

    private static final List<By> LOGIN_FORM_MARKERS = Arrays.asList(
        By.id("login"),
        By.cssSelector("form[action*='login']"),
        By.xpath("//form[.//input[@type='password']]")
    );

    public LoginPage(WebDriver driver, Duration explicitWait) {
        super(driver, explicitWait);
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage typeEmail(String email) {
        WebElement emailInput = findFirstPresent(EMAIL_LOCATORS);
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        WebElement passwordInput = findFirstPresent(PASSWORD_LOCATORS);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public void submit() {
        try {
            WebElement submitButton = findFirstPresent(SUBMIT_LOCATORS);
            submitButton.click();
        } catch (Exception e) {
            // Fallback: press Enter on password field
            WebElement passwordInput = findFirstPresent(PASSWORD_LOCATORS);
            passwordInput.sendKeys(Keys.ENTER);
        }
    }

    public boolean isOnLoginPage() {
        for (By marker : LOGIN_FORM_MARKERS) {
            if (isPresent(marker)) {
                return true;
            }
        }
        // If any of the login fields are present, we are still on login page
        try {
            findFirstPresent(EMAIL_LOCATORS);
            return true;
        } catch (Exception ignored) {}
        try {
            findFirstPresent(PASSWORD_LOCATORS);
            return true;
        } catch (Exception ignored) {}
        return false;
    }
}