package com.assignment2.part2.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

	@Column(name = "NAME")
	private String name;

	/**
	 * TAKEN FROM LECTURE SOURCE CODE NOTES: The mappedBy attribute indicates the
	 * property "category“ in the Book class that provides the association (that is,
	 * linked up by the foreign-key definition in the table). The cascade attribute
	 * means that the update operation should “cascade” to the child. The
	 * orphanRemoval attribute means that after the books have been updated, those
	 * entries that no longer exist in the set should be deleted from the database.
	 */
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Book> books = new HashSet<Book>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	public boolean addBook(Book book) {
		book.setCategory(this);
		return books.add(book);
	}

	public void removeBook(Book book) {
		books.remove(book);
	}

	@Override
	public String toString() {
		return String.format("Category - id: %d, Name: %s", id, name);
	}

}
