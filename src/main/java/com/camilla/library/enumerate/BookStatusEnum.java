package com.camilla.library.enumerate;

/**
 * @author camilla
 *
 */
public enum BookStatusEnum {

	AVAILABLE("Disponível"), BORROWED("Emprestado"), RESERVED("Reservado");

	private String description;

	private BookStatusEnum(String description) {
		setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
