package com.assignment2.part2.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.assignment2.part2.app.config.AppConfig;
import com.assignment2.part2.app.dao.BookDao;
import com.assignment2.part2.app.domain.Book;

public class FindAllWithoutCatAuthApp {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllWithoutCatAuthApp.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		logger.info("============== Find all books start ==============");
		List<Book> booksAll = bookDao.findAllWithoutCatAuth();
		listBooks(booksAll);
		logger.info("============== Find all books end ==============");
		
		ctx.close();
	}
	
	private static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books:");
		for (Book book : books) {
			logger.info(book.toString());
		}
	}

}
