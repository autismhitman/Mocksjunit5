package com.neopane.stubbing;

import java.util.List;

public interface BookRepo {
	
 

	List<Book> findNewBooks(int days);

	Book findBookByBookId(String bookId);

	void save(Book book);
 

}
