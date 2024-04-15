package com.neopane.behaviorverification;

import java.util.List;

public class BookService {
	
	private BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
			this.bookRepo = bookRepo;
	}
	
	
     
	public void addBook(Book book) {
		
		if(book.getPrice()<600) {
			return;
		}
		
		bookRepo.save(book);
	}
	
	
	public void addBookRequest(BookRequest bookRequest) {
		if(bookRequest.getPrice() < 500) {
			return;
		}
		Book book = new Book();
		book.setPrice(bookRequest.getPrice());
		book.setTitle(bookRequest.getTitle());
		book.setPublishedDate(bookRequest.getPublishedDate());
		
		bookRepo.save(book);
	}
	
	public void updatePrice(String bookId, int newPrice) {
		if(bookId==null ) {
			return;
		}
		 
		Book book  =bookRepo.findBookById(bookId);
		
		if(book.getPrice()==newPrice) {
			return;
		}
		book.setPrice(newPrice);		
		bookRepo.save(book);
	}
}
