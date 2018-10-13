package com.assignment2.part1.jdbc.domain;

import java.math.BigDecimal;

public class Book {
	private long id;
	private long category_id;
	private String isbn;
	private String title;
	private BigDecimal price;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String toString() {
		return "Book - Id: " + id + ", Category ID: " + category_id + ", ISBN: " + isbn + ", Title: " + title + ", Price: " + price;
	}

}
