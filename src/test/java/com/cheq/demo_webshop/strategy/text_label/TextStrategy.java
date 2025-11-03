package com.cheq.demo_webshop.strategy.text_label;

import org.openqa.selenium.By;

import com.cheq.demo_webshop.strategy.UiElementStrategies.TextLabelStrategy;

public class TextStrategy implements TextLabelStrategy {
	
	 public By getLocator(String htmlTag, String locatorValue) {
	        return By.xpath("//"+ htmlTag +"[text()='" + locatorValue + "']");
	    }

}
