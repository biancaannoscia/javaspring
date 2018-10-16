package com.assignment2.part2.app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.assignment2.part2.app.config.AppConfig;
import com.assignment2.part2.app.dao.BookDao;
import com.assignment2.part2.app.domain.Author;
import com.assignment2.part2.app.domain.Book;
import com.assignment2.part2.app.domain.Category;

public class InsertBookWithNewAuthApp {
	private static Logger logger = LoggerFactory.getLogger(
			InsertBookWithNewAuthApp.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		//create Category object with existing category name
		Category category = new Category();
		category.setName("Fantasy");
		category.setId(2L);
		
		//create set of authors
		
		//create new Author object and add to set
		Author author = new Author();
		author.setFirstName("John");
		author.setLastName("Steinbeck");

	
		//create new book object and add category and authors created above
		Book book  = new Book();
		book.setIsbn("373857463");
		book.setTitle("Of Mice and Men");
		book.setPrice(new BigDecimal(10.10));
		book.addAuthor(author);
		book.setCategory(category);
		
		bookDao.saveWithNewAuth(book);
		
		logger.info("============== Find all books with new book (of mice and men) and authors (william golding and walt disney) ==============");
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
