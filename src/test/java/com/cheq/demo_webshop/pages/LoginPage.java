package com.cheq.demo_webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cheq.demo_webshop.utils.ElementActionUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private WebDriver driver;
	private ElementActionUtils actions;
	

	private By email = By.id("Email");
	private By password = By.id("Password");
	private By loginBtn = By.xpath("//input[@value='Log in']");

	
			
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ElementActionUtils(driver);
	}		

	public void enterEmail(String userEmail) {
		actions.inputElement(email, userEmail);
	}


	public void enterPassword(String userPassword) {
		actions.inputElement(password, userPassword);
	}
	
	public void clickLoginBtn() {	
		actions.clickElement(loginBtn);
	}
	
	public void clickBooksCategory(String categoryName) {
		By category = By.xpath("//ul[@class='top-menu']//a[normalize-space()='" + categoryName + "']");
		actions.clickElement(category);
	}
}
