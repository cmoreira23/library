package com.camilla.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camilla.library.enumerate.BookStatusEnum;

/**
 * @author camilla
 *
 */
@Entity()
public class BookUnit extends EntityModel {

	private static final long serialVersionUID = 3808561377944464735L;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BookStatusEnum status;

	@JoinColumn(name = "book_id")
	@ManyToOne
	private Book book;

	public BookUnit(BookStatusEnum status, Book book) {
		super();
		this.status = status;
		this.book = book;
	}

	public BookUnit() {
	}

	/**
	 * @return the status
	 */
	public BookStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(BookStatusEnum status) {
		this.status = status;
	}

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

}
