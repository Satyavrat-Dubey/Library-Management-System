package Dao;

import java.util.List;

import POJO.Book;

public interface LibraryDao {
	 boolean addbook(Book b);
	 boolean updatebook(Book b);
	Book searchbook(int bookId);
	boolean issuebook(int bookId, int studentId);
	boolean returnbook(int bookId, int studentId);
	
	List<Book> getallBook();
	List<Book> searchBookByname(String bookname);
	

}
