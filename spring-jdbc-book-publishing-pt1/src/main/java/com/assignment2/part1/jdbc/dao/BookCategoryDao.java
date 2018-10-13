package com.assignment2.part1.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.assignment2.part1.jdbc.domain.Book;
import com.assignment2.part1.jdbc.domain.Category;

public interface BookCategoryDao {
	
	public List<Category> findAllCategories();
	public List<Book> findAllBooks();
	public List<Book> findAllBooksByCategoryName(String name);
	public void insertBook (Book book);
	public void updateBook(Long bookID);
	public void deleteBook (Long bookID);

}
