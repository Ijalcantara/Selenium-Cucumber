package com.cheq.demo_webshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

/**
* Utility class for various wait operations in Selenium WebDriver.
*/
public class WaitUtil {

    private WebDriver driver;

    /**
     * Constructs a WaitUtil with the given WebDriver.
     *
     * @param driver the WebDriver instance to use for waits
     */
    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits for the element located by the given locator to be visible.
     *
     * @param locator the By locator of the element
     * @param timeout the timeout in seconds
     * @return the visible WebElement
     */
    public WebElement waitForElementVisible(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    /**
     * Waits for the element located by the given locator to be clickable.
     *
     * @param locator the By locator of the element
     * @param timeout the timeout in seconds
     * @return the clickable WebElement
     */
    public WebElement waitForElementClickable(By locator, long timeout) {
        // Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for the specified text to be present in the element located by the given locator.
     *
     * @param locator the By locator of the element
     * @param text the text to wait for
     * @param timeout the timeout in seconds
     * @return true if the text is present, false otherwise
     */
    public boolean waitForTextPresent(By locator, String text, long timeout) {
        // Wait for the text to be present in the element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Waits for the current URL to contain the specified partial URL.
     *
     * @param partialUrl the partial URL to wait for
     * @param timeout the timeout in seconds
     */
    public void waitForUrlContains(String partialUrl, long timeout) {
        // Wait for the URL to contain the partial string
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    /**
     * Waits for the element using a fluent wait strategy.
     *
     * @param locator the By locator of the element
     * @param timeout the timeout in seconds
     * @param pollingInterval the polling interval in milliseconds
     * @return the found WebElement
     */
    public WebElement fluentWait(final By locator, long timeout, long pollingInterval) {
    	Wait<WebDriver> fluentWait = new FluentWait<>(driver)
    		.withTimeout(Duration.ofSeconds(timeout))
            .pollingEvery(Duration.ofMillis(pollingInterval))
            .ignoring(NoSuchElementException.class);
        return fluentWait.until(driver -> driver.findElement(locator));
    }

}
 