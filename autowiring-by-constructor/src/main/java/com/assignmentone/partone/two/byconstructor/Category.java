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
	
	//when targetConstructor bean is grabbed from the xml properties file, this class will be analyzed for
	//constructors. Since this constructor has 1 argument of type Book, and a bean of type Book
	//exists in my ApplicationContext.xml, that bean will get injected here
	public Category(Book bookPushkin) {
        this.bookPushkin = bookPushkin;
    }
	
	//xml configuration was used here	
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
