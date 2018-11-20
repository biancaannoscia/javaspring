package com.spring.part3.mvc.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.spring.part3.mvc.domain.Book;

public interface BookService {
	List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    Page<Book> findAllByPage(Pageable pageable);

}
