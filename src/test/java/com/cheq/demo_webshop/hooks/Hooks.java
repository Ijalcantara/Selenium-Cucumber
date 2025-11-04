package com.cheq.demo_webshop.hooks;

import com.cheq.demo_webshop.factory.WebDriverFactory;
import com.cheq.demo_webshop.manager.DriverManager;
import com.cheq.demo_webshop.utils.AllureUtil;
import com.cheq.demo_webshop.utils.ConfigReader;
import com.cheq.demo_webshop.utils.LoggerUtil;
import com.google.common.collect.ImmutableMap;
import io.cucumber.java.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Cucumber hooks for managing WebDriver lifecycle and Allure reporting.
 * Handles setup, teardown, and reporting for each scenario and step.
 */
public class Hooks {

    private static WebDriver driver;
    private AllureUtil allureUtil;
    private static final Logger logger = LoggerUtil.getLogger(Hooks.class);

    /**
     * Initializes WebDriver, loads configuration, and sets up Allure environment before each scenario.
     */
    @Before
    public void setUp(Scenario scenario) throws IOException {
        String env = System.getProperty("env", "dev");
        ConfigReader.loadProperties(env);

        String browser = System.getProperty("browser", ConfigReader.get("browser"));
        String url = ConfigReader.get("baseUrl");

        try {
            // ✅ Load WebDriver (handles headless mode via WebDriverFactory)
            driver = WebDriverFactory.loadDriver(browser);
            driver.manage().window().maximize();
            driver.get(url);
            DriverManager.setDriver(driver);

            // ✅ Initialize Allure reporting utility
            allureUtil = new AllureUtil(driver);

            // ✅ Write environment metadata to Allure report
            allureUtil.writeAllureEnvironment(
                    ImmutableMap.<String, String>builder()
                            .put("OS", System.getProperty("os.name"))
                            .put("Browser", browser)
                            .put("Environment", env)
                            .build()
            );

            logger.info("✅ Starting scenario: " + scenario.getName());
        } catch (Exception e) {
            logger.error("❌ Failed to initialize WebDriver: " + e.getMessage(), e);
            // Do not crash the whole test suite if driver setup fails
            allureUtil = null;
        }
    }

    /**
     * Captures and attaches a screenshot to the Allure report after each step (if possible).
     */
    @AfterStep
    public void afterEachStep(Scenario scenario) {
        if (allureUtil != null && driver != null) {
            try {
                allureUtil.captureAndAttachScreenshot();
            } catch (Exception e) {
                logger.warn("⚠️ Failed to capture step screenshot: " + e.getMessage());
            }
        } else {
            logger.warn("⚠️ Skipping step screenshot — WebDriver or AllureUtil not initialized.");
        }
    }

    /**
     * Captures screenshot on failure and cleans up resources.
     */
    @After(order = 1)
    public void captureFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            if (allureUtil != null && driver != null) {
                try {
                    allureUtil.captureAndAttachScreenshot();
                    logger.error("❌ Scenario failed: " + scenario.getName());
                } catch (Exception e) {
                    logger.error("⚠️ Could not capture failure screenshot: " + e.getMessage());
                }
            } else {
                logger.warn("⚠️ Skipping failure screenshot — AllureUtil not initialized.");
            }
        }
    }

    /**
     * Quits WebDriver after each scenario.
     */
    @After(order = 0)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("🧹 WebDriver closed successfully.");
            } catch (Exception e) {
                logger.error("⚠️ Error while quitting WebDriver: " + e.getMessage());
            } finally {
                driver = null;
            }
        } else {
            logger.warn("⚠️ No WebDriver instance found to close.");
        }
    }
}
