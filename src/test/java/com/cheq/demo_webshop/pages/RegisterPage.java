package com.cheq.demo_webshop.pages;
import com.cheq.demo_webshop.factory.RadioButtonFactory;
import com.cheq.demo_webshop.utils.ElementActionUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {

    private WebDriver driver;
    private ElementActionUtils actions;

    private By firstNameInput = By.xpath("//input[@id='FirstName']");
    private By lastNameInput = By.xpath("//input[@id='LastName']");
    private By emailInput = By.xpath("//input[@id='Email']");
    private By passwordInput = By.xpath("//input[@id='Password']");
    private By confirmPasswordInput = By.xpath("//input[@id='ConfirmPassword']");
    private By registerButton = By.xpath("//input[@id='register-button']");
    private By registrationSuccessMessage = By.xpath("//div[@class='result' and contains(text(),'Your registration completed')]");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActionUtils(driver);
    }

    public void selectGender(String locatorType, String locatorValue) {
    	actions.clickElement(RadioButtonFactory.getRadioButtonStrategy(locatorType)
    			.getLocator(locatorValue));
    }

    public void enterFirstName(String firstName) {
    	actions.inputElement(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
    	actions.inputElement(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
    	actions.inputElement(emailInput, email);
    }

    public void enterPassword(String password) {
    	actions.inputElement(passwordInput, password);
    }
    
    public void enterConfirmPassword(String confirmPassword) {
    	actions.inputElement(confirmPasswordInput, confirmPassword);
    }

    public void clickRegisterButton() {
    	actions.clickElement(registerButton);
    }

    public void isRegistrationSuccessful() {
        actions.verifyDisplayed(registrationSuccessMessage);

    }
}
 