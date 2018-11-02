package com.assignment3.part3.jpa2.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment3.part3.jpa2.app.domain.Book;
import com.assignment3.part3.jpa2.app.service.PublishingService;

public class DeleteApp {
private static Logger logger = LoggerFactory.getLogger(DeleteApp.class);
	
    public static void main(String... args) {
    	//oad config file
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        

        PublishingService publishingService = ctx.getBean(PublishingService.class);
    
		//delete book we previously inserted
		Long idDelete = 7L;
		//Book bookDelete = publishingService.findBookWithCatAuthByBookID(idDelete);
		publishingService.delete(idDelete);
		
		//display info
		logger.info("============== DELETED new book (of mice and men) and authors (william golding and walt disney) ==============");
		List<Book> booksAll = publishingService.findAllWithCatAuth();
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
