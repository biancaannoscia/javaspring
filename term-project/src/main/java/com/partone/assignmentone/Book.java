package com.partone.assignmentone;

public class Book {

	private Long id = 2L;
	private String isbn = "123456789";
	private String title = "Moby Dick";
	private Float price = 39.99f;
	
	public Book() {
		
	}
	
	
	public Book (Long id, String isbn, String title, Float price) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	


	public void setId(Long id) {
		this.id = id;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setPrice(Float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + ", ISBN: " + isbn + ", Title: " + title + ", Price: " + price;
	}

}
