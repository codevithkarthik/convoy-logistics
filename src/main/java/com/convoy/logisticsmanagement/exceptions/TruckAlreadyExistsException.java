package com.convoy.logisticsmanagement.exceptions;

public class TruckAlreadyExistsException extends RuntimeException {

	public TruckAlreadyExistsException(String message) {
		super(message);
	}

	public TruckAlreadyExistsException() {
		super();
	}
	
	

}
