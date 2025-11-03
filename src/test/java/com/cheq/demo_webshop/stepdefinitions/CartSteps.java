package com.cheq.demo_webshop.stepdefinitions;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import com.cheq.demo_webshop.hooks.Hooks;
import com.cheq.demo_webshop.manager.DriverManager;
import com.cheq.demo_webshop.pages.BookPage;
import com.cheq.demo_webshop.pages.CartPage;
import com.cheq.demo_webshop.pages.HomePage;
import com.cheq.demo_webshop.pages.LoginPage;

import io.cucumber.java.en.*;

public class CartSteps {

    WebDriver driver;

    private CartPage cartPage;
    private LoginPage loginPage;
    private BookPage bookPage;
    private HomePage homePage;
    
    public CartSteps() {
    	this.driver = DriverManager.getDriver();
    	this.cartPage = new CartPage(driver);
    	this.loginPage = new LoginPage(driver);
    	this.bookPage = new BookPage(driver);
    	this.homePage = new HomePage(driver);
    }

    @And("User should click on Books category")
    public void user_should_click_on_books_category(DataTable dataTable) {
    	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String category = data.get(0).get("category").trim();
        loginPage.clickBooksCategory(category);
    }

    @And("User should locate Fiction book")
    public void user_should_locate_fiction_book(DataTable dataTable) {
    	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String bookTitle = data.get(0).get("bookTitle").trim();
        cartPage.verifySubCategory(bookTitle);
    }

    @And("User should locate the price")
    public void user_should_locate_the_price() {
     bookPage.isFictionBookPriceVisible();
    }

    @And("User should click add to cart")
    public void user_should_click_add_to_cart() {
     bookPage.clickFictionBook();
     bookPage.clickdAddToCart();

    }

    @And("User should click on the shopping cart link")
    public void user_should_click_on_the_shopping_cart_link() {
     bookPage.clickShoppingCartLink();
    }

    @And("User should locate the remove checkbox")
    public void user_should_locate_the_remove_checkbox() {
     cartPage.isRemoveCheckboxVisible();
    }

    @And("User should click the remove checkbox and update the cart")
    public void user_should_click_the_remove_checkbox_and_update_the_cart(DataTable dataTable) throws InterruptedException {
        cartPage.clickRemoveCheckbox();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String bookTitle = data.get(0).get("bookTitle").trim();
        cartPage.isOrderSummaryVisible(bookTitle);
        cartPage.clickUpdateCartButton();
    }

    @Then("User should click logout")
    public void user_should_click_logout() {
        homePage.header.clickLogout();
    }
}