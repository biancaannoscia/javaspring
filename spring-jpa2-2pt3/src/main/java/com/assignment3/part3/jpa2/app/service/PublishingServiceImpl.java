package com.assignment3.part3.jpa2.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	final static String ALL_BOOK_NATIVE_QUERY =
	        "select * from book";


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
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_BOOK_WITH_AUTHOR_WITH_MULT_BOOKS, 
				Book.class);
		query.setParameter("id", id);
        return query.getResultList();
	}

	public Book saveWithNewAuth(Book book) {
		if (book.getId() == null) {
            logger.info("Inserting new book");
            em.persist(book);
        } else {
            em.merge(book);
            logger.info("Updating existing book");
        }

        logger.info("Book saved with id: " + book.getId());

        return book;
	}

	public void delete(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(readOnly=true)
	public List<Book> findAllByNativeQuery() {
		return em.createNativeQuery(ALL_BOOK_NATIVE_QUERY, "bookResult").getResultList();
	}

}
