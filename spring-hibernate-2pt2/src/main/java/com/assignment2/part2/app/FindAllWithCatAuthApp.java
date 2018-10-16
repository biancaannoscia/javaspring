package com.assignment2.part2.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.assignment2.part2.app.config.AppConfig;
import com.assignment2.part2.app.dao.BookDao;
import com.assignment2.part2.app.domain.Book;

public class FindAllWithCatAuthApp {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllWithCatAuthApp.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		logger.info("============== Find all books start ==============");
		List<Book> booksAll = bookDao.findAllWithCatAuth();
		listBooks(booksAll);
		logger.info("============== Find all books end ==============");
		
		ctx.close();
	}
	
	private static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books with authors:");
		books.forEach(b -> {
			logger.info(b.toString());
			if (b.getAuthors() != null) {
				b.getAuthors().forEach(a -> logger.info("\t" + a.toString()));
			}
			if (b.getCategory() != null) {
				logger.info("\tCategory: " + b.getCategory());
			}
		});
	}

}
