package com.neopane.bdd;

import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;

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
	public void whenPriceisGreaterthanCondn() {
				
	    //given 
		Book book1= new Book("FD1", "Harry Potter", 700, LocalDate.now());
		BDDMockito.given(br.findBookById("FD1")).willReturn(book1);
		
        //when
		bs.updatePrice("FD1", 400);
		
		//then
		BDDMockito.then(br).should().save(book1);
        
  
	}
	
 
	
 
}










