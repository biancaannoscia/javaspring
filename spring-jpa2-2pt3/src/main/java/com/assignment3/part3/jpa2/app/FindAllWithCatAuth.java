package com.assignment3.part3.jpa2.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment3.part3.jpa2.app.domain.Book;
import com.assignment3.part3.jpa2.app.service.PublishingService;

public class FindAllWithCatAuth {

private static Logger logger = LoggerFactory.getLogger(FindAllWithCatAuth.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        logger.info("============== Find all books start ==============");
        List<Book> books = publishingService.findAllWithCatAuth();
        listBooks(books);
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
