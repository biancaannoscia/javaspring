package com.assignmentone.partone.two.bysetter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/* taken from Vitaly's slide: @Service on top of class means that it is an injectable
 bean with the name targetBySetter. The bean is holding business logic providing a service to the application */
@Service("targetBySetter")
public class Category {
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
	private Long id = 1L; 
	private String name = "Poetry"; 
	private static Book bookShakespeare;
	
	
	/* this autowired annotation tells the application that a dependency injection is required.
	During initialization of application context in the main method, all @autowired annotations
	are grabbed. We know Book.java is an injectable bean due to the @Service annotation, so 
	a Book bean can be injected here. The application knows this is a setter method since
	the word "set" is in the beginning of the method name, and it will separate the word set from
	the rest of the name, grab this rest and lowercase the first letter, and see if this name 
	matches any of the property names. Here, bookShakepseare in the method name matches one of the property names,
	and since we also know that beans of type Book are injectable beans, we can inject the Book bean here   */
	@Autowired
	public void setBookShakespeare(Book bookShakespeare) {
        this.bookShakespeare = bookShakespeare;
    }
	
	
	public static void main(String... args) {
		//annotation configuration is used here
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