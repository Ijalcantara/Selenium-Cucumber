package com.cheq.demo_webshop.strategy.radio_button;

import org.openqa.selenium.By;

import com.cheq.demo_webshop.strategy.UiElementStrategies.RadioButtonStrategy;

public class ValueStrategy implements RadioButtonStrategy {
   
    public By getLocator(String locatorValue) {
        return By.xpath("//input[@type='radio' and @value='" + locatorValue + "']");
    }
}
