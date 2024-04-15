package com.neopane.annotationsSupport;

import java.util.List;

public interface BookRepo {
	
 

	List<Book> findNewBooks(int days);
 

}
