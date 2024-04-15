package com.neopane.stubbing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnnotationTestDoReturnWhen {
	
	
	@Mock
	BookRepo br ;
	
	@InjectMocks
	BookService bs;
	
	@Test
	public void demoMockUsingMockAnnotations() {
		
			
		
		List<String>  booksIds = new ArrayList<>();
		booksIds.add("FD1");
		booksIds.add("FD2");
	    
		Book book1= new Book("FD1", "Harry Potter", 500, LocalDate.now());
		Book book2= new Book("FD2", "Lord of the rings", 400, LocalDate.now());

		Mockito.doReturn(book1).when(br).findBookByBookId("FD1");
		Mockito.doReturn(book2).when(br).findBookByBookId("FD2");
		
		int totalCost =  bs.totalCost(booksIds );
		
		Assertions.assertEquals(900, totalCost);
	}
	
	
	@Test
	public void whenVoidReturened() {
		
		Book book1 = new Book("FD1", "Harry Potter", 500, LocalDate.now());
		Mockito.doNothing().when(br).save(book1);
		
		bs.addBook(book1);
	}

}
