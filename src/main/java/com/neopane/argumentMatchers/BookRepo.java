package com.neopane.argumentMatchers;

import java.time.LocalDate;
import java.util.List;

public interface BookRepo {
	
 
	void save(Book book);

	Book findBookById(String bookId);

	Book findBookByTitleAndPublishedDate(String title, LocalDate localDate);

	Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital);
 

}
