package com.cheq.demo_webshop.pages;
import com.cheq.demo_webshop.pages.components.HeaderComponent;
import com.cheq.demo_webshop.utils.ElementActionUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    private WebDriver driver;
    public HeaderComponent header;


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.header = new HeaderComponent(driver);
    }

}
 