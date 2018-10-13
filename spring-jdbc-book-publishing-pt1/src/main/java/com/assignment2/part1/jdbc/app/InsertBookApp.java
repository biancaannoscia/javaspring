package com.assignment2.part1.jdbc.app;

import java.util.List;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment2.part1.jdbc.dao.BookCategoryDaoImpl;
import com.assignment2.part1.jdbc.domain.Book;

public class InsertBookApp {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBooksApp.class);

	public static void main(String[] args) {
		//here we are using xml configuration to inject the dataSource into BookCategoryDaoImpl
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
		
        //Here we initialize the dao class, and create a Book object, passing this into insertBook()
        BookCategoryDaoImpl bookCategoryDaoImpl = ctx.getBean(BookCategoryDaoImpl.class);
        Book newBook = new Book();
        newBook.setCategory_id(1);
        newBook.setIsbn("8475757575");
        newBook.setTitle("Twilight");
        newBook.setPrice(new BigDecimal(10.10));
        
        bookCategoryDaoImpl.insertBook(newBook);
        List<Book> books = bookCategoryDaoImpl.findAllBooks();

        //Here we display the information of the updated Book table with the new Book "Twilight" added
        logger.info("------------Listing books with new book Twilight start-------------------");
        books.forEach(book -> { logger.info(book.toString()); });
		logger.info("------------Listing books end-------------------");

			
        ctx.close();

    }

}
