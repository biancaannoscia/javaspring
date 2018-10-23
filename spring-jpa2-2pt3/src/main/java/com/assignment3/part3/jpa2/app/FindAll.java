package com.assignment3.part3.jpa2.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment3.part3.jpa2.app.domain.Book;
import com.assignment3.part3.jpa2.app.service.PublishingService;

public class FindAll {

private static Logger logger = LoggerFactory.getLogger(FindAll.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        logger.info("============== Find all books start ==============");
        List<Book> books = publishingService.findAllWithoutCatAuth();
        listBooks(books);
        logger.info("============== Find all books end ==============");
		
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing singers:");
		books.forEach(b -> logger.info(b.toString()));
   }

}
