package com.assignmentone.partone.two.byname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Category {
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
	private Long id = 1L; 
	private String name = "Poetry"; 
	private static Book bookFrost;
	
	public void setBookFrost(Book bookFrost) {
        this.bookFrost = bookFrost;
    }
	
	
	public static void main(String... args) {
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
