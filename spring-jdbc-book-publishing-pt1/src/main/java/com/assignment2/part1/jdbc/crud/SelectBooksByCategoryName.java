package com.assignment2.part1.jdbc.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.assignment2.part1.jdbc.app.SelectBooksByCategoryNameApp;
import com.assignment2.part1.jdbc.domain.Book;

public class SelectBooksByCategoryName extends MappingSqlQuery<Book>  {
	private static Logger logger = LoggerFactory.getLogger(
			SelectBooksByCategoryNameApp.class);
	
	
	//Here we are selecting all books that have the category name "Fantasy"
	private static final  String SQL_SELECT_ALL_BOOK_BY_CAT_NAME = 
			" select b.* from book b, category c where c.name = :name and b.category_id = c.id;";
	
	public SelectBooksByCategoryName(DataSource datasource) {
		super(datasource,SQL_SELECT_ALL_BOOK_BY_CAT_NAME);
		super.declareParameter(new SqlParameter("name", Types.VARCHAR));
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
