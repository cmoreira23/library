package com.camilla.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author camilla
 *
 */
@Entity()
public class Client extends EntityModel {

	private static final long serialVersionUID = 5346824869042409397L;

	@Column(nullable = false)
	private String name;

	private String phone;

	public Client() {
	}

	public Client(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
