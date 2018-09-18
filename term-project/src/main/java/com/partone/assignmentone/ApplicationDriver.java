package com.partone.assignmentone;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationDriver {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-xml.xml");
		ctx.refresh();

		Category categorySet = ctx.getBean("categorySet", Category.class);

		categorySet.setId(2L);
		categorySet.setName("Novels");

		categorySet.displayInfo();

		Category categoryList = ctx.getBean("categoryList", Category.class);

		categoryList.setId(3L);
		categoryList.setName("Java");
		List<Book> bookList= categoryList.getBooksList();
		bookList.add(new Book());

		categoryList.displayInfo();

		Category categoryMap = ctx.getBean("categoryMap", Category.class);

		categoryMap.setId(4L);
		categoryMap.setName("Poetry");

		categoryMap.displayInfo();

	}

}
