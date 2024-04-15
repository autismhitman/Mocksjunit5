package com.neopane.mocking.spy;

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
		Assertions.assertEquals(0, fbr.timesCalled());
		bs.addBook(book2);
		Assertions.assertEquals(1, fbr.timesCalled());
		
	}
	
	@Test
	  void testSpyMock() {
		
		BookRepo fbr = Mockito.spy(BookRepo.class);
		BookService bs = new BookService(fbr);
		Book book1 = new Book("FD1", "Harry Potter", 350, LocalDate.now());
		Book book2 = new Book("FD2", "Ohm", 250, LocalDate.now()) ;
		
		bs.addBook(book1);
		bs.addBook(book2);

        Mockito.verify(fbr).save(book2);
        Mockito.verify(fbr,Mockito.times(1)).save(book2);
	}

}
