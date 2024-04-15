package com.neopane.mocking.mock;

import org.junit.jupiter.api.Assertions;

public class FakeBookRepo implements BookRepo{
    
	 int called = 0;
	 Book lastAddedBook= null;
	 
	@Override
	public void save(Book book) {
		 
		called++;
		lastAddedBook= book;
		
		
	}
	
	public void verify(Book book, int times) {
		
		Assertions.assertEquals(times, called) ;
		Assertions.assertEquals(lastAddedBook, book) ;
	}
	
	 

}
