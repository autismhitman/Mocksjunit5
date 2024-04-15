package com.neopane.mocking.fake;

import java.util.Collection;

public interface BookRepo {
	
	
	void save(Book book);
	Collection<Book> findAll();

}
