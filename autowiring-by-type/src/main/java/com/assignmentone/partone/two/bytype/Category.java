package com.assignmentone.partone.two.bytype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Category {
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
	private Long id = 1L; 
	private String name = "Poetry"; 
	private static Book bookWhitman;
	
	public void setBookWithman(Book bookWhitman) {
        this.bookWhitman = bookWhitman;
    }
	
	
	public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        
        Category catWhitman = (Category) ctx.getBean("targetByType");
        
        logger.info("============ bookAutowiredByType Output Start =====================");
        logger.info("Autowiring by type: book - ID: " + bookWhitman.getId() + ", Title: " + bookWhitman.getTitle() + ", ISBN: " + bookWhitman.getIsbn()
        		+ ", Price: " + bookWhitman.getPrice());
        logger.info("============ bookAutowiredByType Output End ================");
        

        ctx.close();
        
    }

}
