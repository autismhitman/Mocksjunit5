package com.neopane.mocking.fake;

public class BookService {
	
	private BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
			this.bookRepo = bookRepo;
	}
	
	
	public int findNumberOfBooks() {
		
		return bookRepo.findAll().size();
	}
	
	public void addBook(Book book) {
		
		bookRepo.save(book);
	}

}
