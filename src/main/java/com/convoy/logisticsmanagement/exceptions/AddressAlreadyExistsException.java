package com.convoy.logisticsmanagement.exceptions;

public class AddressAlreadyExistsException extends RuntimeException{

	public AddressAlreadyExistsException(String message) {
		super(message);
	}

	public AddressAlreadyExistsException() {
		super();
	}
	

}
