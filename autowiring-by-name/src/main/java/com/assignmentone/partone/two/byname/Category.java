package com.assignmentone.partone.two.byname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Category {
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
	private Long id = 1L; 
	private String name = "Poetry"; 
	
	//when targetByName bean is grabbed from the xml properties file, this class will get analyzed
	//for any property names that match the names of any bean ids in application context. 
	//since this class has a property called bookFrost, and application context contains
	//a bean id = bookFrost, that bean will get injected here using the setter method below
	private static Book bookFrost;
	
	//since the method name has bookFrost in the name, this method will be used to inject the bookFrost bean
	public void setBookFrost(Book bookFrost) {
        this.bookFrost = bookFrost;
    }
	
	
	public static void main(String... args) {
		//xml configuration is used here
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();

        Category cat = null;
        
        cat = (Category) ctx.getBean("targetByName");
        
        logger.info("============ bookAutowiredByName Output Start =====================");
        logger.info("Autowiring by name: book - ID: " + bookFrost.getId() + ", Title: " + bookFrost.getTitle() + ", ISBN: " + bookFrost.getIsbn()
        		+ ", Price: " + bookFrost.getPrice());
        logger.info("============ bookAutowiredByName Output End ================");
        

        ctx.close();
        
    }

}
