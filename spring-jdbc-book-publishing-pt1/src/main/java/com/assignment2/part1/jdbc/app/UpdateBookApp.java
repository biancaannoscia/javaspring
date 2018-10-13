package com.assignment2.part1.jdbc.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment2.part1.jdbc.dao.BookCategoryDaoImpl;
import com.assignment2.part1.jdbc.domain.Book;

public class UpdateBookApp {

	private static Logger logger = LoggerFactory.getLogger(
			UpdateBookApp.class);

	public static void main(String[] args) {
		//here we are using xml configuration to inject the dataSource into BookCategoryDaoImpl
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
		
        //Here we initialize the dao class, and deleting a Book object from the book table
        BookCategoryDaoImpl bookCategoryDaoImpl = ctx.getBean(BookCategoryDaoImpl.class);
        bookCategoryDaoImpl.updateBook(8L);

        //Here we display the information of the updated Book table with book with book ID = 8,
        //previously title = "Walt Disney" to title = "Kurt Vonnegut"
        List<Book> books = bookCategoryDaoImpl.findAllBooks();
        logger.info("------------Listing books with book with ID = 8 updated to Kurt Vonnegut start-------------------");
        books.forEach(book -> { logger.info(book.toString()); });
		logger.info("------------Listing books end-------------------");

			
        ctx.close();

    }

}
