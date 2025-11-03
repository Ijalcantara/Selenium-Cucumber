package com.cheq.demo_webshop.strategy.text_label;

import org.openqa.selenium.By;

import com.cheq.demo_webshop.strategy.UiElementStrategies.TextLabelStrategy;

public class ContainsStrategy implements TextLabelStrategy {
	
	 public By getLocator(String htmlTag, String locatorValue) {
	        return By.xpath("//"+ htmlTag +"[contains(text(),'" + locatorValue + "')]");
	    }

}
