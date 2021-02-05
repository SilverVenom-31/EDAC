package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pojo.Book;

public interface IBookDao {
	//add method for getting categories from the books table
	List<String> getBookCategory() throws SQLException;
	
	//add method for getting all available books for particular category
	//select title,author,price from dac_books where category='react';
	List<Book> getBooksByCategory(String categoryName) throws SQLException;
	
	//add method to get book details by id
	Book getBookDetById(int bookId) throws SQLException;
	

}
