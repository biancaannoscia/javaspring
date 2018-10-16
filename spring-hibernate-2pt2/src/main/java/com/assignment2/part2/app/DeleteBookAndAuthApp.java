package com.assignment2.part2.app;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.assignment2.part2.app.config.AppConfig;
import com.assignment2.part2.app.dao.BookDao;
import com.assignment2.part2.app.domain.Author;
import com.assignment2.part2.app.domain.Book;
import com.assignment2.part2.app.domain.Category;

public class DeleteBookAndAuthApp {
	private static Logger logger = LoggerFactory.getLogger(
			DeleteBookAndAuthApp.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		Long idDelete = 23L;
		Book bookDelete = bookDao.findBookWithCatAuthByBookID(idDelete);
		bookDao.delete(bookDelete);
		
		logger.info("============== DELETED new book (of mice and men) and authors (william golding and walt disney) ==============");
		List<Book> booksAll = bookDao.findAllWithCatAuth();
		listBooks(booksAll);
		logger.info("============== Find all books with new book and authors ==============");
		
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
