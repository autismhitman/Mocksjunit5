package com.neopane.behaviorverification;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
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
				
	    
		Book book1= new Book("FD1", "Harry Potter", 700, LocalDate.now());
        bs.addBook(book1);
        Mockito.verify(br,Mockito.times(1)).save(book1);
  
	}
	
	@Test
	public void  whenPriceLessThanCondn() {
		Book book1= new Book("FD1", "Harry Potter", 400, LocalDate.now());		
	    BookRequest brq = new BookRequest("Harry Potter", 400, LocalDate.now());
	    bs.addBookRequest(brq);
	    
	    Mockito.verify(br,times(0)).save(book1);
  
	}
	
	@Test
	public void   whenPriceLessThanCondnUsingNever() {
		Book book1= new Book("FD1", "Harry Potter", 400, LocalDate.now());		
	    BookRequest brq = new BookRequest("Harry Potter", 400, LocalDate.now());
	    bs.addBookRequest(brq);
	    
	    Mockito.verify(br,never()).save(book1);
  
	}

	
	@Test
	public void  whenBookIdisNull() {
	 
	    bs.updatePrice(null, 350);
	    Mockito.verifyNoInteractions(br);
	   
  
	}
	
	@Test
	public void  whenBookOldPriceisSameasNew() {
	 
	    Book book = new Book("FD1", "Harry Potter", 400, LocalDate.now());
		Mockito.when(br.findBookById("FD1")).thenReturn(book);
		bs.updatePrice("FD1", 800);
	    Mockito.verify(br).findBookById("FD1");
	    Mockito.verify(br).save(book);
	    Mockito.verifyNoMoreInteractions(br);
	    
  
	}
	
	
	@Test
	public void  checkWhetherVerifcationIsDoneInOrder() {
	 
	    Book book = new Book("FD1", "Harry Potter", 400, LocalDate.now());
		Mockito.when(br.findBookById("FD1")).thenReturn(book);
		bs.updatePrice("FD1", 800);
		
		InOrder inorder = Mockito.inOrder(br);
        inorder.verify(br).save(book);
		inorder.verify(br).findBookById("FD1");
	    Mockito.verifyNoMoreInteractions(br);
	    
  
	}
	
	
	@Test 
	public void seeingAtMostandAtleast() {
				
	    
		Book book1= new Book("FD1", "Harry Potter", 700, LocalDate.now());
        bs.addBook(book1);
        bs.addBook(book1);
        Mockito.verify(br,Mockito.atLeastOnce()).save(book1);
        Mockito.verify(br,Mockito.atMost(1)).save(book1);
        Mockito.verify(br,Mockito.atLeast(2)).save(book1);
	}
	
	
}
