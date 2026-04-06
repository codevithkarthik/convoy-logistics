package com.convoy.logisticsmanagement.exceptions;

public class TruckCapacityExceededException extends RuntimeException {

	public TruckCapacityExceededException(String message) {
		super(message);
	}

	public TruckCapacityExceededException() {
		super();
	}
	
	
}
