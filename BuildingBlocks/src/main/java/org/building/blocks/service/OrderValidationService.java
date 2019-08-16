package org.building.blocks.service;

import org.building.blocks.exceptions.InvalidOrderReferenceException;

public interface OrderValidationService {
	public void validateOrderReference(String value) throws InvalidOrderReferenceException;

}
