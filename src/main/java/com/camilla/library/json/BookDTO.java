package com.camilla.library.json;

import java.io.Serializable;

import com.camilla.library.model.Book;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 7273268226088806771L;

	private Book book;

	private int quantity;

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
