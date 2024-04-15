package com.neopane.ExceptionHandling;

public class DatabaseReadException extends RuntimeException{
	
	public DatabaseReadException(String message) {
		
		super(message);
	}

}
