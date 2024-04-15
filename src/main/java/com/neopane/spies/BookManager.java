package com.neopane.spies;

public class BookManager {
	
	private BookService bs;

	public BookManager(BookService bs) {
		super();
		this.bs = bs;
	}
	
	public int applyDiscountOnBook(String bookId,int discountRate) {
		
		Book book = bs.findBook(bookId);
		int discountedPrice = bs.getAppliedDiscountedPrice(book, discountRate);
		return discountedPrice;
	}

}
