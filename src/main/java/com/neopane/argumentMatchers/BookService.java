package com.neopane.argumentMatchers;

import java.time.LocalDate;
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
	
	public Book getBookByTitleAndPublishedDate(String title, LocalDate localDate) {
		
		return bookRepo.findBookByTitleAndPublishedDate( title, localDate);
	}
	
    public Book getBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
		
		return bookRepo.findBookByTitleAndPriceAndIsDigital( title, price, isDigital);
	}
}
