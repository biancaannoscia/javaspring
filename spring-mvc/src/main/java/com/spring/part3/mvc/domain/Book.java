package com.spring.part3.mvc.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
public class Book implements Serializable{

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
    
	@NotBlank(message="{validation.isbn.NotBlank.message}")
	@Size(min=10, max=10, message="{validation.isbn.Size.message}")
	@Column(name = "ISBN")
	private String isbn;
	
	@NotBlank(message="{validation.title.NotBlank.message}")
	@Size(min=2, max=200, message="{validation.title.Size.message}")
	@Column(name = "TITLE")
	private String title;
	
	@NotBlank(message="{validation.publisher.NotBlank.message}")
	@Size(min=2, max=200, message="{validation.publisher.Size.message}")
	@Column(name = "PUBLISHER")
	private String publisher;
	
	@NotBlank(message="{validation.categoryname.NotBlank.message}")
	@Size(min=2, max=200, message="{validation.categoryname.Size.message}")
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@NotBlank(message="{validation.price.NotBlank.message}")
	@Column(name = "PRICE")
	private BigDecimal price;
	
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory_name() {
		return categoryName;
	}

	public void setCategory_name(String category_name) {
		this.categoryName = category_name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String toString() {
		return "Book - id: " + id + ", Category Name: " + categoryName +", Title: " + title 
				+ ", Publisher: " + publisher + ", ISBN: " + isbn + ", PRICE: " + price;
	}

}
