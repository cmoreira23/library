package com.camilla.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.camilla.library.enumerate.BookStatusEnum;
import com.camilla.library.json.BookDTO;
import com.camilla.library.model.Book;
import com.camilla.library.model.BookUnit;
import com.camilla.library.repository.BookRepository;
import com.camilla.library.repository.BookUnitRepository;

@Service
public class BookService {

	@Autowired
	private BookUnitRepository bookUnitRepository;

	@Autowired
	private BookRepository bookRepository;

	public List<BookUnit> getAllBookUnits() {
		return this.bookUnitRepository.findAll();
	}

	public List<BookUnit> createBook(BookDTO bookDTO) throws RestClientException {

		Book book = this.saveBook(bookDTO.getBook());
		List<BookUnit> bookUnits = new ArrayList<>();
		for (int i = 0; i < bookDTO.getQuantity(); i++) {
			bookUnits.add(this.createBookInit(book));
		}
		return bookUnits;
	}

	private Book saveBook(Book book) throws RestClientException {
		try {
			this.bookRepository.save(book);
			return book;
		} catch (Exception e) {
			throw new RestClientException("BookService  ---------   Error on Save Book", e);
		}
	}

	private BookUnit createBookInit(Book book) throws RestClientException {
		BookUnit bookUnit = new BookUnit();
		bookUnit.setBook(book);
		bookUnit.setStatus(BookStatusEnum.AVAILABLE);

		try {
			this.bookUnitRepository.save(bookUnit);
			return bookUnit;
		} catch (Exception e) {
			throw new RestClientException("BookService  ---------   Error on Save BookUnit", e);
		}
	}

	public void reserve(Long id) throws RestClientException {

		Optional<BookUnit> bookUnitBD = this.bookUnitRepository.findById(id);

		if (bookUnitBD.isPresent()) {
			bookUnitBD.get().setStatus(BookStatusEnum.RESERVED);
			this.bookUnitRepository.saveAndFlush(bookUnitBD.get());
		} else {
			throw new RestClientException("The book was not found ");
		}

	}

}
