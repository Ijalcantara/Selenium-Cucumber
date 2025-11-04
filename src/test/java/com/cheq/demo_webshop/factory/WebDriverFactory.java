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
     * @param browser the name of the browser ("chrome", "chrome-headless", "firefox", "edge")
     * @return the WebDriver instance
     */
    public static WebDriver loadDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
            case "chrome-headless":
                ChromeOptions options = new ChromeOptions();

                // Read HEADLESS env variable
                boolean isHeadless = Boolean.parseBoolean(
                        System.getProperty("headless", System.getenv().getOrDefault("HEADLESS", "false"))
                );

                // Essential arguments for CI/Linux
                options.addArguments(
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--disable-gpu",
                        "--remote-allow-origins=*",
                        "--window-size=1920,1080"
                );

                if (isHeadless || browser.toLowerCase().contains("headless")) {
                    options.addArguments("--headless=new");
                    System.out.println("🚀 Running Chrome in HEADLESS mode (CI)");
                } else {
                    System.out.println("🧭 Running Chrome in NORMAL mode (Local)");
                }

                // Optional: binary path for GitHub Actions
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
