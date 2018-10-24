package com.assignment3.part3.jpa2.app;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment3.part3.jpa2.app.domain.Author;
import com.assignment3.part3.jpa2.app.domain.Book;
import com.assignment3.part3.jpa2.app.domain.Category;
import com.assignment3.part3.jpa2.app.service.PublishingService;

public class SaveWithNewAuthApp {

private static Logger logger = LoggerFactory.getLogger(SaveWithNewAuthApp.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
		//create Category object with existing category name
		Category category = new Category();
		category.setName("Fantasy");
		category.setId(2L);
		
		
		//create new Author object and add to set
		Author author = new Author();
		author.setFirstName("John");
		author.setLastName("Steinbeck");

	
		//create new book object and add category and authors created above
		Book book  = new Book();
		book.setIsbn("373857463");
		book.setTitle("Of mice and Men");
		book.setPrice(new BigDecimal(10.10));
		book.addAuthor(author);
		book.setCategory(category);
		
		publishingService.saveWithNewAuth(book);
        
        logger.info("============== Find new book start ==============");
        List<Book> books = publishingService.findAllWithoutCatAuth();
        listBooks(books);
        logger.info("============== Find new book end ==============");
		
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
