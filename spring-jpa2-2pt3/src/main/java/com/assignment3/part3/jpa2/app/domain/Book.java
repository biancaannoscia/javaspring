package com.assignment3.part3.jpa2.app.domain;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

//my read only queries; they dont require any changes made to the db

@Entity
@Table(name = "book")
@NamedQueries({
		@NamedQuery(name=Book.FIND_ALL, query="select b from Book b"),
		@NamedQuery(name=Book.FIND_BOOK_WITH_AUTHOR_AND_CATEGORIES,
				query="select distinct b from Book b " +
						"left join fetch b.authors a " +
						"left join fetch b.category c"),
		@NamedQuery(name=Book.FIND_BOOK_WITH_AUTHOR_WITH_MULT_BOOKS,
				query="select distinct b from Book b " +
						"left join fetch b.authors a " +
						"left join fetch b.category c " +
						"where a.id = :id")
		
})
@SqlResultSetMapping(
	     name="bookResult",
	     entities=@EntityResult(entityClass=Book.class)
	)

public class Book  {


	public static final String FIND_BOOK_WITH_AUTHOR_AND_CATEGORIES = 
			"Book.findBookWithAuthorAndCategories";
	public static final String FIND_BOOK_WITH_AUTHOR_WITH_MULT_BOOKS = 
			"Book.findBookWithAuthorWithMultBooks";
	public static final String FIND_ALL = "Book.findAll";

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
	protected Long id;
	
	@Column(name = "ISBN")
	private String isbn;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "PRICE")
	private BigDecimal price;


	//There can be many books that map to one category
	//This is done through the category_id foreign key on the category table
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	
	//many books can map to one author, and many authors can map to one book. 
	//Thus, there is a many-to-many relationship between the two tables
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "author_book",
			//this describes foreign key TO the book table
			joinColumns = @JoinColumn(name = "BOOK_ID"),
			//this describes the foreign key from the book table to the author table
			inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	private Set<Author> authors = new HashSet<Author>();
	

	


	
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

public boolean addAuthor(Author author) {
	return authors.add(author);
}

	public String toString() {
		return "Book - id: " + id + ", Category ID: " + category.getId() +", Title: " + title 
				+ ", ISBN: " + isbn + ", PRICE: " + price;
	}
}
