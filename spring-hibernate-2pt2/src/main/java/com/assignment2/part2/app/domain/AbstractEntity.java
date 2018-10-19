package com.assignment2.part2.app.domain;
import javax.persistence.*;
import java.io.Serializable;

/**
 * copied from lecture material
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    /**
	   @Id means it’s the primary key of the object. Hibernate will use it as the unique 
	   identifier when managing the contact entity instances within its session. Additionally, 
	   the @GeneratedValue annotation tells Hibernate how the id value was generated. 
	   The IDENTITY strategy means that the id value was generated by the back end during insert.
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	protected Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
