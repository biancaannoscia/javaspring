package com.assignment3.part3.jpa2.app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author extends AbstractEntity {

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DESCRIPTION")
	private String description;


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "author_book",
			// this describes foreign key into the author table
			joinColumns = @JoinColumn(name = "AUTHOR_ID"),
			// this describes the foreign key from the author table to the book table
			inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private Set<Author> authors = new HashSet<Author>();


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return String.format("Author - id: %d, First name: %s, Last name: %s, Description: %s",
				id, firstName, lastName, description);
	}
	
}