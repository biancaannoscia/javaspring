package com.assignmentone.partone.three.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public void afterThrowing(Method method, Object[] args, Object target,
    		RuntimeException ex) throws Throwable {
        logger.info("***");
        logger.info("RuntimeException Capture");
        logger.info("Caught: " + ex.getClass().getName());
        logger.info("Method: " + method.getName());
        System.out.print("***\n");
    }
}
