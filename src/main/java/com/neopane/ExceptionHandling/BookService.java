package com.neopane.ExceptionHandling;

import java.sql.SQLException;
import java.util.List;

public class BookService {
	
	private BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
			this.bookRepo = bookRepo;
	}
	
	
   public int getTotalPrice() {
		
		 List<Book> books =null;
		 
		try {
			books = bookRepo.findAllBooks();
		} catch (SQLException e) {
			throw new DatabaseReadException( "Unable to read DB " + e.getMessage());
		}
		 
		 int totalPrice=0;
		 for(Book book : books) {
			 
			 totalPrice+=book.getPrice();
		 }
		 
		 return totalPrice;
	}
   
   public void addBook(Book book) {
	   
	   try {
		bookRepo.save(book);
	} catch (SQLException e) {
	 
		 throw new DatabaseWriteException("Unable to write to DB " + e.getMessage() );
	}
   }
}
