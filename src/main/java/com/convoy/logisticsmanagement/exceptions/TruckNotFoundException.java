package com.convoy.logisticsmanagement.exceptions;

public class TruckNotFoundException extends RuntimeException{

	public TruckNotFoundException(String message) {
		super(message);
	}

	public TruckNotFoundException() {
		super();
	}
	

}
