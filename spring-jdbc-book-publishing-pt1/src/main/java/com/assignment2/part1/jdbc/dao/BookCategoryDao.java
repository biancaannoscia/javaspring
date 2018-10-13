package com.assignment2.part1.jdbc.dao;

import java.util.List;

import com.assignment2.part1.jdbc.domain.Book;
import com.assignment2.part1.jdbc.domain.Category;

public interface BookCategoryDao {
	
	public List<Category> findAllCategories();
	public List<Book> findAllBooks();
	public List<Book> findAllBooksByCategoryName(String catName);
	public void insertBook (Book book);
	public void updateBook(Book book);
	public void deleteBook (Book book);

}
