package com.assignmentone.partone.two.bysetter;

import org.springframework.stereotype.Service;

@Service("book")
public class Book {
	private Long id; 
	private String isbn; 
	private String title; 
	private Float price;
	
	public Book() {
		this.id = 4L;
		this.isbn = "121234456734";
		this.title = "Shakespeare Poetry";
		this.price = 11.11F;
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