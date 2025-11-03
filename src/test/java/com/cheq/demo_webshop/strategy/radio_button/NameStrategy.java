package com.cheq.demo_webshop.strategy.radio_button;

import org.openqa.selenium.By;

import com.cheq.demo_webshop.strategy.UiElementStrategies.RadioButtonStrategy;

public class NameStrategy implements RadioButtonStrategy {
	
	public By getLocator(String locator) {
		return By.name(locator);
	}
	
}
