package com.cheq.demo_webshop.strategy.dropdown;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cheq.demo_webshop.strategy.UiElementStrategies.DropdownStrategy;

public class SelectByIndexStrategy implements DropdownStrategy {
    public void select(WebElement dropdown, String value) {
    	int index = Integer.parseInt(value);
        new Select(dropdown).selectByIndex(index);
    }
}

