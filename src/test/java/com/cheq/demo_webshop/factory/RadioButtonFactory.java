package com.cheq.demo_webshop.factory;

import com.cheq.demo_webshop.strategy.UiElementStrategies.RadioButtonStrategy;
import com.cheq.demo_webshop.strategy.radio_button.IdStrategy;
import com.cheq.demo_webshop.strategy.radio_button.NameStrategy;
import com.cheq.demo_webshop.strategy.radio_button.ValueStrategy;

public class RadioButtonFactory {

	public static RadioButtonStrategy getRadioButtonStrategy(String type) {
		switch(type.toLowerCase()) {
		case "id": return new IdStrategy();
		case "name": return new NameStrategy();
		case "value": return new ValueStrategy();
		default: throw new IllegalArgumentException("Unsupported locator type");
		}
	}
}

 