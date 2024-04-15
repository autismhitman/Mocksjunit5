package com.neopane.spies;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpyTest {
	
	
	@Test
	public void testMockitoSpy() {
		
		BookService bs = Mockito.spy(BookService.class);
		BookManager bm  = new BookManager(bs);
		
		
	}

}
