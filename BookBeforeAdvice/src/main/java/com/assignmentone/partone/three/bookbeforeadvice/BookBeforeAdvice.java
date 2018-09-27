package com.assignmentone.partone.three.bookbeforeadvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BookBeforeAdvice implements MethodBeforeAdvice{
	private static Logger logger = LoggerFactory.getLogger(
			BookBeforeAdvice.class);

	public static void main(String[] args) {
		Book book = new Book();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BookBeforeAdvice());
		pf.setTarget(book);
		
		Book proxy = (Book) pf.getProxy();
		proxy.reading();

	}
	
	public void before(Method method, Object[] args, Object target)
            throws Throwable {
        logger.info("Before '" + method.getName() + "' buy the book.");
    }

}
