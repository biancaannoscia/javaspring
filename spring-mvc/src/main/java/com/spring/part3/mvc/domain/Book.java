package com.spring.part3.mvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
	@Column(name = "ISBN")
	private String isbn;
	
	@NotBlank(message="{validation.title.NotBlank.message}")
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "PUBLISHER")
	private String publisher;
	
	@NotBlank(message="{validation.categoryname.NotBlank.message}")
	@Column(name = "CATEGORY_NAME")
	private String category_name;
	
	@NotNull(message="{validation.price.NotNull.message}")
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
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String toString() {
		return "Book - id: " + id + ", Category Name: " + category_name +", Title: " + title 
				+ ", Publisher: " + publisher + ", ISBN: " + isbn + ", PRICE: " + price;
	}

}
