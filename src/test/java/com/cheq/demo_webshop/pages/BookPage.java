package com.cheq.demo_webshop.pages;
import com.cheq.demo_webshop.utils.ElementActionUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage {

    private WebDriver driver;
    private ElementActionUtils elementActionUtils;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        this.elementActionUtils = new ElementActionUtils(driver);
    }

    private By fictionBookTitle = By.xpath("//h2[@class='product-title']/a[normalize-space(text())='Fiction']");
    private By fictionBookPrice = By.xpath("//h2[@class='product-title']/a[text()='Fiction']/ancestor::div[@class='details']//span[contains(@class, 'actual-price')]");
    private By addToCartButton = By.xpath("//input[contains(@id, 'add-to-cart-button')]");
    private By shoppingCartLink = By.cssSelector("a[class='ico-cart'] span[class='cart-label']");


    public void isFictionBookVisible() {
        elementActionUtils.verifyDisplayed(fictionBookTitle);
    }

    public void isFictionBookPriceVisible() {
    	elementActionUtils.verifyDisplayed(fictionBookPrice);
    }

    public void clickFictionBook() {
    	elementActionUtils.clickElement(fictionBookTitle);
    }

    public void clickdAddToCart() {
        elementActionUtils.clickElement(addToCartButton);
    }

    public void clickShoppingCartLink() {
    	elementActionUtils.clickElement(shoppingCartLink);
    }
}
 