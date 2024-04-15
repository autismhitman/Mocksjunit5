package com.neopane.ExceptionHandling;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	@Test 
	public void testTotalPriceOfBooks() throws SQLException  {
				
	  //  List<Book> list= new ArrayList<>();
	  //  list.add(new Book("FD1", "Mantras",350,LocalDate.now()));
	 //   list.add(new Book("FD2", "LOD",450,LocalDate.now()));
	    
	     Mockito.when(br.findAllBooks()).thenThrow(SQLException.class);
	     assertThrows(DatabaseReadException.class,() -> bs.getTotalPrice());
	 
  
	}
	
	@Test 
	public void usingBDD() throws SQLException {
		
	     BDDMockito.given(br.findAllBooks()).willThrow(SQLException.class);
	     assertThrows(DatabaseReadException.class,() -> bs.getTotalPrice());
 
	}
	
	@Test 
	public void testTotalPriceOfBooks2() throws SQLException  {
				
	 
	     Mockito.when(br.findAllBooks()).thenThrow(new SQLException("Unable to read DB"));
	     assertThrows(DatabaseReadException.class,() -> bs.getTotalPrice());
	 
  
	}
	
	@Test 
	public void whenMockObjectMethodisVoid() throws SQLException   {
		 
		Book book = new Book("FD1", "Mantras",350,LocalDate.now());
		Mockito.doThrow(SQLException.class).when(br).save(book);
	    assertThrows(DatabaseWriteException.class, ()->bs.addBook(book));
	     
	 
  
	}
}
