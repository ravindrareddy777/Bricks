package org.building.blocks.exceptions;

public class InvalidOrderReferenceException extends Exception {
	
	
	private static final long serialVersionUID = -3640899745060073706L;

	private static final String MSG = "Order Reference Id is Invalid";

	public InvalidOrderReferenceException() {
		super();
	}

	public InvalidOrderReferenceException(String message) {
		super(MSG);
	}
	
	

}
