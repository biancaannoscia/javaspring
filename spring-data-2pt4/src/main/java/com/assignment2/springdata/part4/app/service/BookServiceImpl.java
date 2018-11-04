package com.assignment2.springdata.part4.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment2.springdata.part4.app.domain.Book;
import com.assignment2.springdata.part4.app.repository.BookRepository;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service("springJpaBookService")
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly=true)
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Transactional(readOnly=true)
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
		
	}

}
