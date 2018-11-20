package com.spring.part3.mvc.repository;

import com.spring.part3.mvc.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

}
