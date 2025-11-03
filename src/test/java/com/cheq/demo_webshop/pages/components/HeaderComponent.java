package com.cheq.demo_webshop.pages.components;
import com.cheq.demo_webshop.factory.TextLabelFactory;
import com.cheq.demo_webshop.utils.ElementActionUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderComponent {

    private WebDriver driver;
    private ElementActionUtils elementActionUtils;

    // Locators
    private By logoutLink = By.cssSelector(".ico-logout");
    private By loginLink = By.cssSelector(".ico-login");
    private By registerLink = By.cssSelector(".ico-register");

    // Constructor
    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        this.elementActionUtils = new ElementActionUtils(driver);
    }

    public void clickLoginLink(String strategyType, String htmlTag, String message) {
    	elementActionUtils.clickElement(TextLabelFactory.getStrategy(
				strategyType).getLocator(htmlTag, message));  
    }

    public void isLogoutLinkDisplayed() {
    	elementActionUtils.verifyDisplayed(logoutLink);
    }

    public void clickLogout() {
    	elementActionUtils.clickElement(logoutLink);
    }

    public void isLoginLinkDisplayed() {
    	elementActionUtils.verifyDisplayed(loginLink);
    }

    public void isRegisterLinkDisplayed() {
    	elementActionUtils.verifyDisplayed(registerLink);
    }

    public void clickRegisterLink() {
    	elementActionUtils.clickElement(registerLink);
    }
}
 