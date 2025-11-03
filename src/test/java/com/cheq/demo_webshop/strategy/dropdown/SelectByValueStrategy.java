package com.cheq.demo_webshop.strategy.dropdown;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cheq.demo_webshop.strategy.UiElementStrategies;
import com.cheq.demo_webshop.strategy.UiElementStrategies.DropdownStrategy;

public class SelectByValueStrategy implements DropdownStrategy {
	 public void select(WebElement dropdown, String value) {
	       new Select(dropdown).selectByValue(value);
	    }

}
