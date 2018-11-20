package com.spring.part3.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.spring.part3.mvc.domain.Book;
import com.spring.part3.mvc.repository.BookRepository;


@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	public void setBookRepository (BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return Lists.newArrayList(bookRepository.findAll());
	}

	@Transactional(readOnly = true)
	public Book findById(Long id) {
		return bookRepository.findById(id).get();
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Transactional(readOnly = true)
	public Page<Book> findAllByPage(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

}
