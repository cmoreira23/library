package com.camilla.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author camilla
 *
 */
@Entity()
public class Author extends EntityModel {

	private static final long serialVersionUID = 6578859287682334256L;

	private String firstName;

	@Column(nullable = false)
	private String lastName;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
