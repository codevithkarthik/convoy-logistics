package com.convoy.logisticsmanagement.exceptions;

public class DriverAlreadyExistsException extends RuntimeException {

	public DriverAlreadyExistsException(String message) {
		super(message);
	}

	public DriverAlreadyExistsException() {
		super();
	}
	

}
