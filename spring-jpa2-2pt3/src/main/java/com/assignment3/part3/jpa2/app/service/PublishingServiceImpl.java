package com.assignment3.part3.jpa2.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment3.part3.jpa2.app.domain.Book;

@Service("jpaPublishingsService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PublishingServiceImpl implements PublishingService{
	private static Logger logger = LoggerFactory.getLogger(PublishingServiceImpl.class);


    @PersistenceContext
    private EntityManager em;
    
    @Transactional(readOnly=true)
	public List<Book> findAllWithoutCatAuth() {
    	 return em.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
	}

    @Transactional(readOnly=true)
	public List<Book> findAllWithCatAuth() {
		List<Book> books = em.createNamedQuery(Book.FIND_BOOK_WITH_AUTHOR_AND_CATEGORIES, 
				Book.class).getResultList();
        return books;
	}

	public Book findBookWithCatAuthByBookID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> findAllWithCatAuthMultBookPerAuthId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book saveWithNewAuth(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Book book) {
		// TODO Auto-generated method stub
		
	}

	public List<Book> findAllByNativeQuery() {
		// TODO Auto-generated method stub
		return null;
	}

}
