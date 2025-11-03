package com.cheq.demo_webshop.manager;

import org.openqa.selenium.WebDriver;

/**
* Provides a global access point for managing the WebDriver instance
* used throughout the test session. Ensures that all tests use the same
* WebDriver, supporting browser automation and resource management.
*/
public class DriverManager {
    private static WebDriver driver;

    /**
     * Retrieves the current WebDriver instance.
     * This allows test classes to interact with the browser.
     *
     * @return the active WebDriver instance, or null if not set
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Assigns the WebDriver instance to be used for browser automation.
     * Typically called during test setup to initialize the driver.
     *
     * @param driverInstance the WebDriver to use for the session
     */
    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }
}
 