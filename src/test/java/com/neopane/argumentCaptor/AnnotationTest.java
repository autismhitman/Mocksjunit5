package com.neopane.argumentCaptor;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnnotationTest {
	
	
	@Mock
	BookRepo br ;
	
	@InjectMocks
	BookService bs;
	
	@Test 
	public void whenPriceisGreaterthanCondn() {
		Book book1= new Book(null, "Harry Potter", 700, LocalDate.now());
	    BookRequest brq= new BookRequest("Harry Potter", 700, LocalDate.now());
	    
	    
	    bs.addBook(brq);
	    Mockito.verify(br, Mockito.times(1)).save(book1);
	     
  
	}
	
	@Test 
	public void uingArgumentCaptor() {
	 
	    BookRequest brq= new BookRequest("Harry Potter", 700, LocalDate.now());
	    bs.addBook(brq);
	    ArgumentCaptor<Book> ag =  ArgumentCaptor.forClass(Book.class);
	    verify(br).save(ag.capture());
	    
	    Assertions.assertEquals(ag.getValue().getTitle(),"Harry Potter" );
	    
	     
  
	}
	
	
}
