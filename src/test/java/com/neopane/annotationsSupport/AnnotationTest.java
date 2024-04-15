package com.neopane.annotationsSupport;

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
public class AnnotationTest {
	
	
	@Mock
	BookRepo br ;
	
	@InjectMocks
	BookService bs;
	
	@Test
	public void demoMockUsingMockAnnotations() {
		
			
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(new Book("FD1", "Harry Potter", 500, LocalDate.now()));
		newBooks.add(new Book("FD2", "Lord of the rings", 400, LocalDate.now()));
		
		Mockito.when(br.findNewBooks(7)).thenReturn(newBooks);
		
		 List<Book> afterDiscount= bs.getNewBooks(10,7);
		 Assertions.assertEquals(2, afterDiscount.size());
		 Assertions.assertEquals(450, afterDiscount.get(0).getPrice());
		 Assertions.assertEquals(360, afterDiscount.get(1).getPrice());
	 
		
	}

}
