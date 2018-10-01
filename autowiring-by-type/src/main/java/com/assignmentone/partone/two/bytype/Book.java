package com.assignmentone.partone.two.bytype;

public class Book {
	private Long id; 
	private String isbn; 
	private String title; 
	private Float price;
	
	public Book() {
		
	}
	
	public Book (String isbn, String title, Float price, Long id) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	

}
