package com.neopane.ExceptionHandling;

public class DatabaseWriteException extends RuntimeException {
	
	public DatabaseWriteException (String message) {
		
		super(message);
	}

}
