package com.assignmentone.partone.three.springaop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;


public class BookAfterReturningAdvice implements AfterReturningAdvice {
	private static Logger logger = LoggerFactory.getLogger(BookAfterReturningAdvice.class);

	public static void main(String[] args) {
		Book book = new Book();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BookAfterReturningAdvice());
		pf.setTarget(book);
		
		Book proxy = (Book) pf.getProxy();
		proxy.reading();

	}

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.info("After '" + method.getName()+ "' write the book review.");
		
	}

}
