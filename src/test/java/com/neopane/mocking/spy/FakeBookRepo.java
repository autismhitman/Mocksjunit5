package com.neopane.mocking.spy;

 
public class FakeBookRepo implements BookRepo{
    
	 int called = 0;
	 Book lastAddedBook= null;
	 
	@Override
	public void save(Book book) {
		 
		called++;
		lastAddedBook= book;
		
		
	}
	
	public int timesCalled() {
		return called;
	}
	
    public boolean calledWith(Book book) {
		
    	
    	return lastAddedBook.equals(book);
    }

}
