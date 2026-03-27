package com.convoy.logisticsmanagement.exceptions;

public class DriverNotFoundException extends RuntimeException {

	public DriverNotFoundException(String message) {
		super(message);
	}
	public DriverNotFoundException() {
		super();
	}
}
