package com.cheq.demo_webshop.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
 