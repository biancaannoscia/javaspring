//package com.spring.part3.mvc;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//import com.spring.part3.mvc.domain.Book;
//import com.spring.part3.mvc.service.BookService;
//
//
//
//public class MainClass {
//	
//	private static Logger logger = LoggerFactory.getLogger(MainClass.class);
//	
//    public static void main(String... args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/datasource-tx-jpa.xml");
//        ctx.refresh();
//
//        BookService bookService = ctx.getBean("bookService", BookService.class);
//        
//        logger.info("============== Find all books start ==============");
//        List<Book> books = bookService.findAll();
//        listBooks(books);
//        logger.info("============== Find all books end ==============");
//		
//        ctx.close();
//    }
//    
//    public static void listBooks(List<Book> books) {
//		logger.info(" ---- Listing books:");
//		books.forEach(b -> logger.info(b.toString()));
//   }
//
//}
//
//
