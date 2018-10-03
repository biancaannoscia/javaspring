package com.assignmentone.partone.two.bytype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Category {
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
	private Long id = 1L; 
	private String name = "Poetry"; 
	
	//when targetByType bean is grabbed from the xml properties file, this class will get analyzed
	//for any property types that match the types of any beans in application context. 
	//since this class has a property called bookWhitman of type Book, and application context contains
	//a bean id = bookWhitman with type = Book, that bean will get injected here using the setter method below
	private static Book bookWhitman;
	
	//when targetByType bean is grabbed from the xml properties file, this class will be analyzed for
	//constructors. Since this constructor has 1 argument of type Book, and a bean of type Book
	//exists in my ApplicationContext.xml, that bean will get injected here
	public void setBookWithman(Book bookWhitman) {
        this.bookWhitman = bookWhitman;
    }
	
	
	public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //xml configuration used
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
