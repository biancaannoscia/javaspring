package com.assignmentone.partone.three.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//we implement ThrowsAdvice which forces us to implement the "afterThrowing" method, which will execute 
//if after a method call by our "target" throws an exception
//taken from lecture slide: Throws advice is executed after a method invocation returns, but only if that invocation
//threw an exception.
public class BookThrowsAdvice implements ThrowsAdvice {
	private static Logger logger = LoggerFactory.getLogger(
			BookThrowsAdvice.class);
			
    public static void main(String... args) throws Exception {
        Book errorBean = new Book();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(errorBean);
        pf.addAdvice(new BookThrowsAdvice());

        Book proxy = (Book) pf.getProxy();

        try {
            proxy.throwException();
        } catch (Exception ignored) {

        }

    }
    
    //this gets called if the throwException() method throws an exception
    public void afterThrowing(Method method, Object[] args, Object target,
    		RuntimeException ex) throws Throwable {
        logger.info("***");
        logger.info("RuntimeException Capture");
        logger.info("Caught: " + ex.getClass().getName());
        logger.info("Method: " + method.getName());
        System.out.print("***\n");
    }
}
