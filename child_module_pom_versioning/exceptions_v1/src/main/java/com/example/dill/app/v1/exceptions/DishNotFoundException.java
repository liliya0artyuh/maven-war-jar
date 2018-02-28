package com.example.dill.app.v1.exceptions;

public class DishNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8396615217934097187L;
	
	public DishNotFoundException(String dishId) {
		super("could not find dish '" + dishId + "'.");
	}
	
	public DishNotFoundException() {
		super("could not find any dishes.");
	}
}