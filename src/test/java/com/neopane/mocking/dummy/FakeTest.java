package com.neopane.mocking.dummy;

 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class FakeTest {
	
	@Test
	 void testDummy() {
		
		BookRepo  fbr = new FakeBookRepo();
		EmailService fakeEmailService = new FakeEmailService();
		BookService bs = new BookService(fbr, fakeEmailService);
		bs.addBook(new Book("FD1", "Harry Potter", 350, LocalDate.now()));
		bs.addBook(new Book("FD2", "Ohm", 250, LocalDate.now()));
		
		Assertions.assertEquals(2, bs.findNumberOfBooks());
		
	}
	
	@Test
	 void testDUmmyWithMockito() {
		
		BookRepo  fbr = Mockito.mock(BookRepo.class);
		EmailService fakeEmailService = Mockito.mock(EmailService.class);
		BookService bs = new BookService(fbr, fakeEmailService);
		
		
		Collection<Book> bList= new ArrayList<>();
		bList.add(new Book("FD1", "Harry Potter", 350, LocalDate.now()));
		bList.add(new Book("FD2", "Ohm", 250, LocalDate.now()));
		
		Mockito.when(fbr.findAll()).thenReturn(bList);
		Assertions.assertEquals(2, bs.findNumberOfBooks());
		
	}

}
