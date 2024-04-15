package com.neopane.mocking.stub;

import java.time.LocalDate;
import java.util.List;

public class FakeBookRepo implements BookRepo{

	@Override
	public List<Book> findNewBooks(int days) {
		
		
		return List.of(new Book("FD1", "Harry Potter", 500, LocalDate.now()),
				       new Book("FD2", "Lord of the rings", 400, LocalDate.now())); 
	}
	
	 
	 
	
 

}
