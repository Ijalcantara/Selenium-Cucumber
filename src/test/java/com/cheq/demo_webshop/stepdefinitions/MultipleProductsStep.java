package com.cheq.demo_webshop.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import com.cheq.demo_webshop.pages.CartPage;
import com.cheq.demo_webshop.pages.HomePage;
import com.cheq.demo_webshop.pages.MultipleProductsPage;

import com.cheq.demo_webshop.manager.DriverManager;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class MultipleProductsStep {

	WebDriver driver;

    private MultipleProductsPage productsPage;
    private HomePage homePage;
    private CartPage cartPage;
    
    public MultipleProductsStep() {
    	this.driver = DriverManager.getDriver();
    	this.productsPage = new MultipleProductsPage(driver);
    	this.homePage = new HomePage(driver);
    	this.cartPage = new CartPage(driver);
    }

    @Given("User navigate to webshop")
    public void user_navigate_to_webshop() {
    	homePage.header.isLoginLinkDisplayed();
    }

    @When("User should search for a product and click add to cart")
    public void user_should_search_and_add_to_cart(DataTable dataTable) {
        List<Map<String, String>> productList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : productList) {
        	String keyword = product.get("keyword");
        	String item = product.get("item");

            productsPage.searchForProduct(keyword);
            productsPage.clickSearchButton();
            productsPage.clickProduct(item);
            productsPage.addToCart();

        }
    }

    @And("User should click the shopping cart")
    public void user_should_click_cart() {
        productsPage.clickShoppingCart();
    }

    @Then("Verify added products")
    public void verify_added_products(DataTable dataTable) {
        List<Map<String, String>> expectedProducts = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : expectedProducts) {
            String item = product.get("item");
            String expectedPrice = product.get("price");
            productsPage.verifyProductPrice(item, expectedPrice);
        }
    }
    
    @When("User select country")
    public void user_select_country(DataTable dataTable) throws InterruptedException {
    	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
    	String strategyType = data.get(0).get("strategyType").trim();
    	String locatorValue = data.get(0).get("locatorValue").trim();
    	String selectedValue = data.get(0).get("selectedValue").trim();
    	cartPage.selectCountry(strategyType, locatorValue, selectedValue);
    	Thread.sleep(2000);  
    }
}
 