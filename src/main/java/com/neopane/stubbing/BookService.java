package com.neopane.stubbing;

import java.util.List;

public class BookService {
	
	private BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
			this.bookRepo = bookRepo;
	}
	
	public List<Book> getNewBooks(int discount, int days){
		
		  List<Book> newBooks =  bookRepo.findNewBooks(days);
		 
		  for(Book book: newBooks) {
			  
			    int newPrice= book.getPrice()-(book.getPrice()*discount/100);
			    book.setPrice(newPrice);
		  }
		  
		  return newBooks;
	}
	
	public int totalCost(List<String> bookIds) {
		
		int total = 0;
		
		for(String bookId :bookIds) {
			Book book = bookRepo.findBookByBookId(bookId);
			total = total+ book.getPrice();
		}
		
		
		return total;
	}
     
	public void addBook(Book book) {
		
		bookRepo.save(book);
	}
}
