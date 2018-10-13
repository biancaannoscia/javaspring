package com.assignment2.part1.jdbc.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.assignment2.part1.jdbc.domain.Book;

//taken from slide:  MappingSqlQuery<T>: The MappingSqlQuery<T> class allows you to wrap the query string
//together with the mapRow() method into a single class.

public class FindAllBooks extends MappingSqlQuery<Book> {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBooks.class);
	
	private static final  String SQL_SELECT_ALL_BOOK = 
			"select * from book";
	
	public FindAllBooks(DataSource datasource) {
		super(datasource,SQL_SELECT_ALL_BOOK);
	}
	
	protected Book mapRow (ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		
		book.setCategory_id(rs.getLong("category_id"));
		book.setId(rs.getLong("id"));
		book.setIsbn(rs.getString("isbn"));
		book.setPrice(rs.getBigDecimal("price"));
		book.setTitle(rs.getString("title"));

		return book;	
		
	}

}
