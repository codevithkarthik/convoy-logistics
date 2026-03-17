package com.convoy.logisticsmanagement.exceptions;

public class AddressNotFoundException extends RuntimeException {

	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException() {
		super();
	}

}
