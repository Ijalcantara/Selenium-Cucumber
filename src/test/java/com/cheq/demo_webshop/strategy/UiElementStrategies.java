package com.cheq.demo_webshop.strategy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UiElementStrategies {

	public interface TextLabelStrategy{
		By getLocator(String tag, String value);
	}

	public interface DropdownStrategy{
		void select(WebElement dropdown, String value);
	}

	public interface RadioButtonStrategy{
		By getLocator(String value);
	}

}
 