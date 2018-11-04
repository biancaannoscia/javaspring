package com.assignment2.springdata.part4.app;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment2.springdata.part4.app.service.BookService;
import com.assignment2.springdata.part4.app.domain.Book;

public class FindAllApp {

private static Logger logger = LoggerFactory.getLogger(FindAllApp.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean("springJpaBookService", BookService.class);
        
        logger.info("============== Find all books start ==============");
        List<Book> books = bookService.findAll();
        listBooks(books);
        logger.info("============== Find all books end ==============");
		
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing singers:");
		books.forEach(b -> logger.info(b.toString()));
   }

}
