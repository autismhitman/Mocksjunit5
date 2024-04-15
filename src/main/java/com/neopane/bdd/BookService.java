package com.neopane.bdd;

import java.util.List;

public class BookService {
	
	private BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
			this.bookRepo = bookRepo;
	}

	public void updatePrice(String bookId, int newPrice) {
	 
		 
		Book book  =bookRepo.findBookById(bookId);
	 
		book.setPrice(newPrice);		
		bookRepo.save(book);
	}
}
