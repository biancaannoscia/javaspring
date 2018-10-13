package com.assignment2.part1.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.assignment2.part1.jdbc.crud.FindAllCategories;
import com.assignment2.part1.jdbc.domain.Book;
import com.assignment2.part1.jdbc.domain.Category;

public class BookCategoryDaoImpl implements BookCategoryDao, InitializingBean {
	/* This class contains methods that interact with the PUBLISHINGDB database, or more specifically,
	 * operations on the Book and Category tables such as creating, reading, updating and 
	 * deleting records. It contains  all of the data access for information regarding Book and Category. 
	*/
	
	private FindAllCategories findAllCategories;
	
	/* taken from slide: You can delegate to Spring managing the database connection for you by 
	 * providing a bean that implements javax.sql.DataSource. After a DataSource bean 
	 * is created it provisions and manages connections.
	 * */
	
	private DataSource dataSource;


	public List<Category> findAllCategories() {
		return findAllCategories.execute();
	}

	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> findAllBooksByCategoryName(String catName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.findAllCategories = new FindAllCategories(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}

