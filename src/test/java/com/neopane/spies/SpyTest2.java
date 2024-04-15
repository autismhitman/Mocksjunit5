package com.neopane.spies;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpyTest2 {
	
	@Spy
	private BookService bs;
	
	
	@InjectMocks
	private BookManager bm;
	
	
	@Test
	public void testMockitoSpy() {
		
	  Book book = new Book("FD1" ,"HP",200, LocalDate.now());
	  
	 // Mockito.when(bs.findBook("FD1")).thenReturn(book); //when using spy avoid whenthenReturn, this goes to aplly actual method.
		
	  Mockito.doReturn(book).when(bs).findBook("FD1"); // this will work on exception as well.
	  int newPrice= bm.applyDiscountOnBook("FD1", 10);
	  Assertions.assertEquals(180,newPrice);	
	}

}
