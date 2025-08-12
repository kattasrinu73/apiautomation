package com.tripstax.base;

import com.tripstax.pages.DashboardPage;
import com.tripstax.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Properties config;

    protected Duration explicitWait() {
        long seconds = Long.parseLong(config.getProperty("explicitWaitSeconds", "30"));
        return Duration.ofSeconds(seconds);
    }

    protected Duration pageLoadTimeout() {
        long seconds = Long.parseLong(config.getProperty("pageLoadTimeoutSeconds", "60"));
        return Duration.ofSeconds(seconds);
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        config = new Properties();
        Path configPath = Path.of("src", "test", "resources", "config.properties");
        try (FileInputStream fis = new FileInputStream(configPath.toFile())) {
            config.load(fis);
        }

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", config.getProperty("headless", "true")));

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        options.addArguments(
            "--window-size=1536,960",
            "--disable-gpu",
            "--no-sandbox",
            "--disable-dev-shm-usage",
            "--disable-infobars",
            "--disable-notifications",
            "--remote-allow-origins=*"
        );
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) { }
        }
    }

    protected LoginPage loginPage() {
        return new LoginPage(driver, explicitWait());
    }

    protected DashboardPage dashboardPage() {
        return new DashboardPage(driver, explicitWait());
    }
}