package com.partone.assignmentone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Category {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(Category.class);
	
		private Long id;
		private String name;
		private Map<String, Book> booksMap = new HashMap<> ();
		private Set<Book> booksSet = new HashSet<>();
		private List<Book> booksList = new ArrayList<>();
		
		public void setBooksMap(Map<String, Book> booksMap) {
			this.booksMap = booksMap;
		}

		
		public Map<String, Book> getBooksMap() {
			return booksMap;
		}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		

		public Set<Book> getBooksSet() {
			return booksSet;
		}


		public void setBooksSet(Set<Book> booksSet) {
			this.booksSet = booksSet;
		}


		public List<Book> getBooksList() {
			return booksList;
		}


		public void setBooksList(List<Book> booksList) {
			this.booksList = booksList;
		}


		public void displayInfo() {
			
			if (!booksMap.isEmpty()) {
				logger.info("==================== Books Map Output Start ========================");
				logger.info("Category -- ID: " + id + ", Name: " + name );
				booksMap.entrySet().stream().forEach(e -> logger.info(e.getKey() + "=Book - " + e.getValue()));
				logger.info("==================== Books Map Output End =========================");
			} else if (!booksSet.isEmpty()) {
				logger.info("==================== Books Set Output Start ========================");
				logger.info("Category -- ID: " + id + ", Name: " + name );
				booksSet.forEach(obj -> logger.info("Value: " + obj));
				logger.info("==================== Books Set Output End =========================");
				
			} else if (!booksList.isEmpty()) {
				logger.info("==================== Books List Output Start ========================");
				logger.info("Category -- ID: " + id + ", Name: " + name );
				booksList.forEach(obj -> logger.info("Value: " + obj));
				logger.info("==================== Books List Output End =========================");
			}
 
		}
	

}
