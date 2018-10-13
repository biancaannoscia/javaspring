package com.assignment2.part1.jdbc.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment2.part1.jdbc.dao.BookCategoryDaoImpl;
import com.assignment2.part1.jdbc.domain.Book;

public class FindAllBooksApp {

	private static Logger logger = LoggerFactory.getLogger(
			FindAllBooksApp.class);

	public static void main(String[] args) {
		//here we are using xml configuration to inject the dataSource into BookCategoryDaoImpl
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        
        
        //Here we initialize the dao class, and execute find all books
        BookCategoryDaoImpl bookCategoryDaoImpl = ctx.getBean(BookCategoryDaoImpl.class);
        List<Book> books = bookCategoryDaoImpl.findAllBooks();

        //Here we display the information
        logger.info("------------Listing books start-------------------");
        books.forEach(book -> { logger.info(book.toString()); });
		logger.info("------------Listing books end-------------------");

			
        ctx.close();

	}

}
