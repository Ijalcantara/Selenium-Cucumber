package com.cheq.demo_webshop.pages;
import com.cheq.demo_webshop.utils.ElementActionUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MultipleProductsPage {

    private WebDriver driver;
    private ElementActionUtils elementActionUtils;

    public MultipleProductsPage(WebDriver driver) {
        this.driver = driver;
        this.elementActionUtils = new ElementActionUtils(driver);
    }

    // Locators
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("//input[@value='Search']");
    private By cartLink = By.xpath("//span[@class='cart-label']");


    public void searchForProduct(String keyword) {
    	elementActionUtils.inputElement(searchBox, keyword);
    }

    public void clickSearchButton() {
    	elementActionUtils.clickElement(searchButton);
    }

    public void clickProduct(String productName) {
    	By itemLink = By.xpath("//a[contains(text(), '" + productName + "')]");
    	elementActionUtils.clickElement(itemLink);
    }

    public void addToCart() {
    	By addToCartButton = By.xpath("//input[contains(@id,'add-to-cart-button')]");
    	elementActionUtils.clickElement(addToCartButton);
    }

    public void clickShoppingCart() {
        elementActionUtils.clickElement(cartLink);
    }

    public void verifyProductPrice(String productName, String expectedPrice) {
        By priceLocator = By.xpath("//a[text()='" + productName + "']/ancestor::tr//span[@class='product-unit-price']");
        elementActionUtils.getTextAndCompare(priceLocator, expectedPrice);

    }
}
 