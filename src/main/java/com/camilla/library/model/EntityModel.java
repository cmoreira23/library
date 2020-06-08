package com.camilla.library.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author camilla
 *
 */
@MappedSuperclass
public abstract class EntityModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}
