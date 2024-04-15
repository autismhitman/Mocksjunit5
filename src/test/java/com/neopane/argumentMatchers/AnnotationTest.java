package com.neopane.argumentMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

 

@ExtendWith(MockitoExtension.class)
public class AnnotationTest {
	
	
	@Mock
	BookRepo br ;
	
	@InjectMocks
	BookService bs;
	
	
	//Argument Matchers
	@Test
	public void argMatchers() {
		
		Book book1= new Book("FD1", "Harry Potter", 300, LocalDate.now());
		Book book2= new Book("FD1", "Harry Potter", 500, LocalDate.now());
		Mockito.when(br.findBookById(any())).thenReturn(book1);
		bs.updatePrice("FD1", 500);
		Mockito.verify(br).save(book2);
		
	}
	
	@Test
	public void argMatchers1() {
		
		Book book1= new Book("FD1", "Harry Potter", 300, LocalDate.now());
		Book book2= new Book("FD1", "Harry Potter", 500, LocalDate.now());
		Mockito.when(br.findBookById(any(String.class))).thenReturn(book1);
		bs.updatePrice("FD1", 500);
		Mockito.verify(br).save(book2);
		
	}
	
	
	@Test
	public void argMatchers2() {
		
		Book book1= new Book("FD1", "Harry Potter", 300, LocalDate.now());
	    Mockito.when(br.findBookByTitleAndPublishedDate("Harry Potter", LocalDate.now())).thenReturn(book1);
		Book actualBook = bs.getBookByTitleAndPublishedDate("Harry Potter", LocalDate.now());
		 
		Assertions.assertEquals("Harry Potter", actualBook.getTitle());
		
	}
	
	@Test//both the parameters should have the arg matchers.
	public void argMatchers3() {
		
		Book book1= new Book("FD1", "Harry Potter", 300, LocalDate.now());
	    Mockito.when(br.findBookByTitleAndPublishedDate(eq("Harry Potter"), any())).thenReturn(book1);
		Book actualBook = bs.getBookByTitleAndPublishedDate("Harry Potter", LocalDate.now());
		 
		Assertions.assertEquals("Harry Potter", actualBook.getTitle());
		
	}
	
	@Test//both the parameters should have the arg matchers.
	public void argMatchers4() {
		
		Book book1= new Book("FD1", "Harry Potter", 300, LocalDate.now());
	    Mockito.when(br.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book1);
		Book actualBook = bs.getBookByTitleAndPriceAndIsDigital("Harry Potter", 300, true);
		 
		Assertions.assertEquals("Harry Potter", actualBook.getTitle());
		
	}
}










