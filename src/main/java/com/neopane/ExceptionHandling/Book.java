package com.neopane.ExceptionHandling;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
	
	private String bookId;
    private String title;
    private int price;
    private LocalDate publishedDate;
    
	public Book() {
		 
	}

	public Book(String bookId, String title, int price, LocalDate publishedDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.publishedDate = publishedDate;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", publishedDate=" + publishedDate
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, publishedDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return price == other.price && Objects.equals(publishedDate, other.publishedDate)
				&& Objects.equals(title, other.title);
	}
    
    

}
