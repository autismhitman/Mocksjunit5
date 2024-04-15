package com.neopane.mocking.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class FakeTest {
	
	@Test
	  void testFake() {
		
		FakeBookRepo fbr = new FakeBookRepo();
		BookService bs = new BookService(fbr);
		Book book1 = new Book("FD1", "Harry Potter", 350, LocalDate.now());
		Book book2 = new Book("FD2", "Ohm", 250, LocalDate.now()) ;
		
		bs.addBook(book1);
		 
		bs.addBook(book2);
		fbr.verify(book2, 1);
		
	}
	
	
	@Test
	  void testMOck() {
		
		BookRepo fbr = Mockito.mock(BookRepo.class);
		BookService bs = new BookService(fbr);
		
		Book book1 = new Book("FD1", "Harry Potter", 350, LocalDate.now());
		Book book2 = new Book("FD2", "Ohm", 250, LocalDate.now()) ;
		
		bs.addBook(book1);
		bs.addBook(book2);
		
		//Mockito.verify(fbr).save(book1);
		Mockito.verify(fbr).save(book2);
		Mockito.verify(fbr, Mockito.times(1)).save(book2);
	}

}
