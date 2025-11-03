package com.cheq.demo_webshop.stepdefinitions;

import com.cheq.demo_webshop.utils.JSONReader;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import com.cheq.demo_webshop.pages.HomePage;
import com.cheq.demo_webshop.pages.RegisterPage;

import com.cheq.demo_webshop.manager.DriverManager;

import io.cucumber.java.en.*;

public class RegisterSteps {

	WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private JSONReader jsonReader;
    
    public RegisterSteps() {
    	this.driver = DriverManager.getDriver();
    	this.homePage = new HomePage(driver);
    	this.registerPage = new RegisterPage(driver);
        this.jsonReader = new JSONReader("testdata.json");
    }

    @Given("User navigate to webshop registration page")
    public void user_navigate_to_webshop_registration_page() throws InterruptedException {
    	Thread.sleep(1000);
    	homePage.header.isRegisterLinkDisplayed();
        homePage.header.clickRegisterLink(); 
    }

    @When("User should input valid credentials")
    public void user_should_input_valid_credentials() {

    	registerPage.enterFirstName(jsonReader.getValue("register", "first_name"));
        registerPage.enterLastName(jsonReader.getValue("register", "last_name"));
        registerPage.enterEmail(jsonReader.getValue("register", "email"));
        registerPage.enterPassword(jsonReader.getValue("register", "password"));
        registerPage.enterConfirmPassword(jsonReader.getValue("register", "password"));
    }

    @And("User click register button")
    public void user_click_register_button() {
    	registerPage.clickRegisterButton();
    }

    @Then("Verify registration is complete")
    public void verify_registration_is_complete() {
    	registerPage.isRegistrationSuccessful();
    }
    
    @Then("The following radio buttons should be selected:")
    public void the_following_radio_buttons_should_be_selected(DataTable dataTable) throws InterruptedException {
    	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
    	Map<String, String> row = data.get(1);
    	String locatorType = row.get("locatorType").trim();
    	String locatorValue = row.get("locatorValue").trim();
    	registerPage.selectGender(locatorType, locatorValue);
    }
 
}

 