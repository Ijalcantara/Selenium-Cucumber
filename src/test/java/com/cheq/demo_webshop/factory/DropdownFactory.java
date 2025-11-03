package com.cheq.demo_webshop.factory;

import com.cheq.demo_webshop.strategy.UiElementStrategies.DropdownStrategy;
import com.cheq.demo_webshop.strategy.dropdown.SelectByIndexStrategy;
import com.cheq.demo_webshop.strategy.dropdown.SelectByTextStrategy;
import com.cheq.demo_webshop.strategy.dropdown.SelectByValueStrategy;

public class DropdownFactory {

	public static DropdownStrategy getStrategy(String type) {
		switch (type.toLowerCase()) {
		case "text":
			return new SelectByTextStrategy();
		case "value":
			return new SelectByValueStrategy();
		case "index":
			return new SelectByIndexStrategy();
		default:
			throw new IllegalArgumentException("Invalid dropdown strategy: " + type);
		}
	}
}
 