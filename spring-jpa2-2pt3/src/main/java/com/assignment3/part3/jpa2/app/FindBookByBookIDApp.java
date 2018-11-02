package com.assignment3.part3.jpa2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.assignment3.part3.jpa2.app.domain.Book;
import com.assignment3.part3.jpa2.app.service.PublishingService;


public class FindBookByBookIDApp {
	private static Logger logger = LoggerFactory.getLogger(
			FindBookByBookIDApp.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
		
		logger.info("============== Find book with author and category by ID start ==============");
		Long idFind = 1L;
		Book  bookById = publishingService.findBookWithCatAuthByBookID(idFind);
		logger.info(bookById.toString());
		if (bookById.getAuthors() != null) {
			bookById.getAuthors().forEach(a -> logger.info("\t" + a.toString()));
		}
		if (bookById.getCategory() != null) {
			logger.info("\tCategory: " + bookById.getCategory());
		}
		logger.info("============== Find book with author and category by ID end ==============");
		
		ctx.close();
}
}
