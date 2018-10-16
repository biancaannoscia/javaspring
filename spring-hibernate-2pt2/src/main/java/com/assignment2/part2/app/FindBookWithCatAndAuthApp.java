package com.assignment2.part2.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.assignment2.part2.app.config.AppConfig;
import com.assignment2.part2.app.dao.BookDao;
import com.assignment2.part2.app.domain.Book;



public class FindBookWithCatAndAuthApp {
	private static Logger logger = LoggerFactory.getLogger(
			FindBookWithCatAndAuthApp.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		logger.info("============== Find book with author and category by ID start ==============");
		Long idFind = 1L;
		Book  bookById = bookDao.findBookWithCatAuthByBookID(idFind);
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
