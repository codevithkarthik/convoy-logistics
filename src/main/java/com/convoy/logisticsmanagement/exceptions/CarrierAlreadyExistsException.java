package com.convoy.logisticsmanagement.exceptions;

public class CarrierAlreadyExistsException extends RuntimeException{

	public CarrierAlreadyExistsException(String message) {
		super(message);
	}

	public CarrierAlreadyExistsException() {
		super();
	}

}
