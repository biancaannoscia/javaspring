package com.assignmentone.partone.three.springaop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

//we implement MethodBeforeAdvice which forces us to implement the "before" method, which will execute 
//before methods called by our "target"
//taken from slides: Before advice allows custom processing before a joinpoint executes. This essentially allows
//you to perform preprocessing before the method executes.
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
	//this method is executed before reading() gets called. 
	public void before(Method method, Object[] args, Object target)
            throws Throwable {
        logger.info("Before '" + method.getName() + "' buy the book.");
    }



}
