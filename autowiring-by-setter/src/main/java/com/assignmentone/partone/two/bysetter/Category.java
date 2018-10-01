package com.assignmentone.partone.two.bysetter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("targetBySetter")
public class Category {
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
	private Long id = 1L; 
	private String name = "Poetry"; 
	private static Book bookShakespeare;
	
	@Autowired
	public void setBookShakespeare(Book bookShakespeare) {
        this.bookShakespeare = bookShakespeare;
    }
	
	
	public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();

        Category cat = null;
        
        cat = (Category) ctx.getBean("targetBySetter");
        
        logger.info("============ bookAutowiredBySetter Output Start =====================");
        logger.info("Autowiring by name: book - ID: " + bookShakespeare.getId() + ", Title: " + bookShakespeare.getTitle() + ", ISBN: " + bookShakespeare.getIsbn()
        		+ ", Price: " + bookShakespeare.getPrice());
        logger.info("============ bookAutowiredBySetter Output End ================");
        

        ctx.close();
        
    }

}