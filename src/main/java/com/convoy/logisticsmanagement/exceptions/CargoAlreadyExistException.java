package com.convoy.logisticsmanagement.exceptions;

public class CargoAlreadyExistException extends RuntimeException {

	public CargoAlreadyExistException(String message) {
		super(message);
	}

	public CargoAlreadyExistException() {
		super();
	}

}
