package com.assignment2.part2.app.dao;

import java.util.List;

import com.assignment2.part2.app.domain.Book;

public interface BookDao {
	
	List<Book> findAllWithoutCatAuth();
	
	List<Book> findAllWithCatAuth();
	
	Book findBookWithCatAuthByBookID(Long id);
	
	List<Book> findAllWithCatAuthMultBookPerAuthId(Long id);
	
	Book saveWithNewAuth(Book book);
	
	void delete(Book book);

}
