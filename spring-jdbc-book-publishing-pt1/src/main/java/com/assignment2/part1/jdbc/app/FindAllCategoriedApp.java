package com.assignment2.part1.jdbc.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment2.part1.jdbc.dao.BookCategoryDaoImpl;
import com.assignment2.part1.jdbc.domain.Category;


//implementing find all categories
public class FindAllCategoriedApp {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllCategoriedApp.class);

	public static void main(String[] args) {
		//here we are using xml configuration to inject the dataSource into BookCategoryDaoImpl
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        
        
        //Here we initialize the dao class, and execute find all categories
        BookCategoryDaoImpl bookCategoryDaoImpl = ctx.getBean(BookCategoryDaoImpl.class);
        List<Category> categories = bookCategoryDaoImpl.findAllCategories();

        //Here we display the information
        logger.info("------------Listing categories start-------------------");
		categories.forEach(category -> { logger.info(category.toString()); });
		logger.info("------------Listing categories end-------------------");

			
        ctx.close();

	}
	

}
