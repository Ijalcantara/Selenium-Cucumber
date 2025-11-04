package com.cheq.demo_webshop.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Factory class for creating WebDriver instances based on browser type.
 */
public class WebDriverFactory {

    /**
     * Loads a WebDriver instance for the specified browser.
     *
     * @param browser the name of the browser ("chrome", "firefox", "edge")
     * @return the WebDriver instance
     * @throws IllegalArgumentException if the browser is not supported
     */
    public static WebDriver loadDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                // ✅ Check for headless flag from system property or environment variable
                boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless",
                        System.getenv().getOrDefault("HEADLESS", "false")));

                if (isHeadless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                    System.out.println("Running Chrome in HEADLESS mode for CI/CD environment.");
                } else {
                    System.out.println("Running Chrome in NORMAL mode for local testing.");
                }

                return new ChromeDriver(options);

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
