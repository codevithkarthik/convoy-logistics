package com.convoy.logisticsmanagement.exceptions;

public class CarrierNotFoundException extends RuntimeException {

	public CarrierNotFoundException(String message) {
		super(message);
	}

	public CarrierNotFoundException() {
		super();
	}
	

}
