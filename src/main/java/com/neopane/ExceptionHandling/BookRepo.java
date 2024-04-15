package com.neopane.ExceptionHandling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepo {
	
 
	void save(Book book) throws SQLException;

	List<Book> findAllBooks() throws SQLException ;

	 
 

}
