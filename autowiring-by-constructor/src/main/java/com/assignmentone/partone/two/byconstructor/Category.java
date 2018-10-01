package com.assignmentone.partone.two.byconstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Category {
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
	private Long id = 1L; 
	private String name = "Poetry"; 
	private static Book bookPushkin;
	
	public Category(Book bookPushkin) {
        this.bookPushkin = bookPushkin;
    }
	
	
	public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        
        Category catPushkin = (Category) ctx.getBean("targetConstructor");
        
        logger.info("============ bookAutowiredByConstructor Output Start =====================");
        logger.info("Autowiring by type: book - ID: " + bookPushkin.getId() + ", Title: " + bookPushkin.getTitle() + ", ISBN: " + bookPushkin.getIsbn()
        		+ ", Price: " + bookPushkin.getPrice());
        logger.info("============ bookAutowiredByConstructor Output End ================");
        

        ctx.close();
        
    }

}
