package com.cheq.demo_webshop.stepdefinitions;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import com.cheq.demo_webshop.manager.DriverManager;
import com.cheq.demo_webshop.pages.HomePage;
import com.cheq.demo_webshop.pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginSteps {

	WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;
    public LoginSteps() {
    	this.driver = DriverManager.getDriver();
    	this.loginPage = new LoginPage(driver);
    	this.homePage = new HomePage(driver);
    }

    @Given("User navigate to webshop login page")
    public void user_navigate_to_webshop_login_page(DataTable dataTable) {
    	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);
        String strategyType = row.get("strategyType").trim();
        String locatorTag = row.get("locatorTag").trim();
        String message = row.get("message").trim();

         homePage.header.clickLoginLink(strategyType, locatorTag, message);

    }

    @When("User should input valid login credentials")
    public void user_should_input_valid_login_credentials(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);

        String username = credentials.get(0).get("username").trim();
        String password = credentials.get(0).get("password").trim();
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
    }

    @And("Verify successfull login")
    public void verify_successfull_login() {
    	homePage.header.isLogoutLinkDisplayed();
    }

    @And("User click logout button")
    public void user_click_logout_button() {
        homePage.header.clickLogout();
    }

    @Then("Verify successfull logout")
    public void verify_successfull_logout() {
    	homePage.header.isLoginLinkDisplayed();
    }
}
