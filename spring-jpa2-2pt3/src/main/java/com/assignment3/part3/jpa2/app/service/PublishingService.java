package com.assignment3.part3.jpa2.app.service;

import java.util.List;

import com.assignment3.part3.jpa2.app.domain.Book;

public interface PublishingService {
	List<Book> findAllWithoutCatAuth();
	
	List<Book> findAllWithCatAuth();
	
	Book findBookWithCatAuthByBookID(Long id);
	
	List<Book> findAllWithCatAuthMultBookPerAuthId(Long id);
	
	Book saveWithNewAuth(Book book);
	
	void delete(Book book);
	
	List<Book> findAllByNativeQuery();

}
