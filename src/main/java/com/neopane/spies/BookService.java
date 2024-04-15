package com.neopane.spies;



public class BookService {
	
 
	public Book findBook(String bookId) {
		
		throw new RuntimeException("Not implemented");
	}
	
	public int getAppliedDiscountedPrice(Book book, int discountRate) {
		
		int price = book.getPrice();
		int newPrice = price - (price*discountRate/100);
		return newPrice;
		
	}
 
}
