package com.assignment2.springdata.part4.app.service;

import com.assignment2.springdata.part4.app.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
	List<Book> findAll();
	Optional<Book> findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
    

}
