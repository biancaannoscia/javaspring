package com.assignment2.part2.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment2.part2.app.domain.Book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
@Transactional
@Repository("bookDao")
public class BookDaoImpl implements BookDao{

	private static final Log logger = LogFactory.getLog(BookDaoImpl.class);
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<Book> findAllWithCatAuth() {
		return sessionFactory.getCurrentSession().
				getNamedQuery("Book.findBookWithAuthorAndCategories").list();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> findAllWithoutCatAuth() {
		return sessionFactory.getCurrentSession().createQuery("from Book b").list();
	}

	@Transactional(readOnly = true)
	public Book findBookWithCatAuthByBookID(Long id) {
		return (Book) sessionFactory.getCurrentSession().
				getNamedQuery("Book.findBookWithAuthorAndCategoriesByID").
				setParameter("id", id).uniqueResult();
	}

	@Transactional(readOnly = true)
	public List<Book> findAllWithCatAuthMultBookPerAuthId(Long id) {
		return sessionFactory.getCurrentSession().
				getNamedQuery("Book.findBookWithAuthorWithMultBooks").
				setParameter("id", id).list();
	}

	
	public Book saveWithNewAuth(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		logger.info("Book saved with id: " + book.getId());
		return book;
	}

	
	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
		logger.info("Book deleted with id: " + book.getId());
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//Inject the SessionFactory
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
