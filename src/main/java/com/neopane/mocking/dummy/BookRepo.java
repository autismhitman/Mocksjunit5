package com.neopane.mocking.dummy;

import java.util.Collection;

public interface BookRepo {
	
	
	void save(Book book);
	Collection<Book> findAll();

}
