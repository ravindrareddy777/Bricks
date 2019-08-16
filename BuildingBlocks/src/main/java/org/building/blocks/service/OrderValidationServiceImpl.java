package org.building.blocks.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.building.blocks.exceptions.InvalidOrderReferenceException;
import org.building.blocks.util.ValidationRule;
import org.springframework.stereotype.Service;

@Service("OrderValidationServiceImpl")
public class OrderValidationServiceImpl implements OrderValidationService {

	@Override
	public void validateOrderReference(String value) throws InvalidOrderReferenceException {
		boolean result = false;

		String msg = "Order Reference Id is Invalid";

		result = validateInputValue(ValidationRule.NAME, value);

		if (!result) {
			throw new InvalidOrderReferenceException(msg);
		}
	}
	
	private boolean validateInputValue(ValidationRule rule, String value) {
		Pattern pattern = rule.getPattern();
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
		
	}

}
