package com.neopane.mocking.stub;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class FakeTest {
	
	@Test
	 void testStub() {
		
		BookRepo  fbr = new FakeBookRepo();
		BookService bs = new BookService(fbr);
				
		Assertions.assertEquals(2, bs.getNewBooks(10, 7).size());
		Assertions.assertEquals(450, bs.getNewBooks(10, 7).get(0).getPrice());
		Assertions.assertEquals(360, bs.getNewBooks(10, 7).get(1).getPrice());
	}
	
	@Test
	 void testStubUsingMockito() {
		
		BookRepo  fbr = Mockito.mock(BookRepo.class);
		BookService bs = new BookService(fbr);
		
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(new Book("FD1", "Harry Potter", 500, LocalDate.now()));
		newBooks.add(new Book("FD2", "Lord of the rings", 400, LocalDate.now()));
		
		Mockito.when(fbr.findNewBooks(7)).thenReturn(newBooks);
		
		List<Book> newBookswithDiscount = bs.getNewBooks(10, 7);
				
		Assertions.assertEquals(2, newBookswithDiscount.size());
		Assertions.assertEquals(450, newBookswithDiscount.get(0).getPrice());
		Assertions.assertEquals(360, newBookswithDiscount.get(1).getPrice());
	}


}
