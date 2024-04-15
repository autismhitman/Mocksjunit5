package com.neopane.argumentCaptor;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnnotationTest2 {
	
	
	@Mock
	BookRepo br ;
	
	@InjectMocks
	BookService bs;
	
	@Captor
	ArgumentCaptor<Book> ag;
	
	@Test 
	public void uingArgumentCaptor() {
	 
	    BookRequest brq= new BookRequest("Harry Potter", 700, LocalDate.now());
	    bs.addBook(brq);
	    verify(br).save(ag.capture());
	    Assertions.assertEquals(ag.getValue().getTitle(),"Harry Potter" );

	}
	
	
}
