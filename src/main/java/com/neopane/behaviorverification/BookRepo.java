package com.neopane.behaviorverification;

import java.util.List;

public interface BookRepo {
	
 
	void save(Book book);

	Book findBookById(String bookId);
 

}
