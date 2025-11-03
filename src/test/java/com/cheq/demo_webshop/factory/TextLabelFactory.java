package com.cheq.demo_webshop.factory;

import com.cheq.demo_webshop.strategy.UiElementStrategies.TextLabelStrategy;
import com.cheq.demo_webshop.strategy.text_label.ContainsStrategy;
import com.cheq.demo_webshop.strategy.text_label.TextStrategy;

public class TextLabelFactory {
	
	public static TextLabelStrategy getStrategy(String type) {
		switch(type.toLowerCase()) {
			case "text": return new TextStrategy();
			case "contains": return new ContainsStrategy();
			default: throw new IllegalArgumentException("Unsupported locator type");
		}
	}
}

 