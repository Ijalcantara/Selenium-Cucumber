package com.cheq.demo_webshop.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Arrays;

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

                // ✅ Read HEADLESS from GitHub Actions or local run
                boolean isHeadless = Boolean.parseBoolean(System.getProperty(
                        "headless",
                        System.getenv().getOrDefault("HEADLESS", "false")
                ));

                // ✅ Always set essential args for Linux-based runners
                options.addArguments(
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--disable-gpu",
                        "--remote-allow-origins=*",
                        "--window-size=1920,1080"
                );

                if (isHeadless) {
                    options.addArguments("--headless=new");
                    System.out.println("🚀 Running Chrome in HEADLESS mode (GitHub Actions)");
                } else {
                    System.out.println("🧭 Running Chrome in NORMAL mode (Local)");
                }

                // ✅ Optional: set binary path for GitHub Actions Chrome
                String chromeBinary = System.getenv("CHROME_BIN");
                if (chromeBinary != null && !chromeBinary.isEmpty()) {
                    options.setBinary(chromeBinary);
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
