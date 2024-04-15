package com.neopane.mocking.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepo implements BookRepo{
	
	Map<String, Book> fakeDB = new HashMap<>();
	

	@Override
	public void save(Book book) {
		 
		fakeDB.put(book.getBookId(), book);
	}

	@Override
	public Collection<Book> findAll() {
		 
		return fakeDB.values();
	}

}
