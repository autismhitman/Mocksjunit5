package com.neopane.mocking.fake;

 

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class FakeTest {
	
	@Test
	 void testFake() {
		
		BookRepo  fbr = new FakeBookRepo();
		BookService bs = new BookService(fbr);
		bs.addBook(new Book("FD1", "Harry Potter", 350, LocalDate.now()));
		bs.addBook(new Book("FD2", "Ohm", 250, LocalDate.now()));
		
		Assertions.assertEquals(2, bs.findNumberOfBooks());
		
	}
	
	
	@Test
	void testFakeWithMockito() {
		BookRepo  fakeBookRepo = Mockito.mock(BookRepo.class);
		BookService bs = new BookService(fakeBookRepo);
		
		Book book1 = new Book("FD1", "Harry Potter", 350, LocalDate.now());
		Book book2 = new Book("FD2", "Ohm", 250, LocalDate.now());
		
		Collection<Book> book = new ArrayList<>();
		book.add(book1);
		book.add(book2);
		
		Mockito.when(fakeBookRepo.findAll()).thenReturn(book);
		 
		assertEquals(2, bs.findNumberOfBooks());
		
	}

}
