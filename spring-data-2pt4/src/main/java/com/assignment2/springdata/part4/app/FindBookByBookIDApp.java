package com.assignment2.springdata.part4.app;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment2.springdata.part4.app.domain.Book;
import com.assignment2.springdata.part4.app.service.BookService;


public class FindBookByBookIDApp {
	private static Logger logger = LoggerFactory.getLogger(
			FindBookByBookIDApp.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean("springJpaBookService", BookService.class);
		
		logger.info("============== Find book with author and category by ID start ==============");
		Long idFind = 1L;
		Optional<Book>  bookOptional = bookService.findById(idFind);
		Book bookById = bookOptional.get();
		logger.info(bookById.toString());
		if (bookById.getAuthors() != null) {
			bookById.getAuthors().forEach(a -> logger.info("\t" + a.toString()));
		}
		if (bookById.getCategory() != null) {
			logger.info("\tCategory: " + bookById.getCategory());
		}
		logger.info("============== Find book with author and category by ID end ==============");
		
		ctx.close();
}
}
