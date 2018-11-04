package com.assignment2.springdata.part4.app.repository;

import com.assignment2.springdata.part4.app.domain.Book;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

	public <S extends Book> S save(S entity);

	List<Book> findAll();
	
	Optional<Book> findById(Long id);

	void deleteById(Long id);



	

}
