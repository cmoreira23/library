package com.camilla.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.camilla.library.enumerate.BookStatusEnum;
import com.camilla.library.json.BookDTO;
import com.camilla.library.model.Author;
import com.camilla.library.model.Book;
import com.camilla.library.model.BookUnit;
import com.camilla.library.repository.BookUnitRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

	@Autowired
	private BookService bookService;
	@MockBean
	private BookUnitRepository bookUnitRepository;

	@Before
	public void setUp() {

		List<BookUnit> bookUnits = new ArrayList<BookUnit>();
		bookUnits.add(new BookUnit(BookStatusEnum.AVAILABLE, new Book("Sapiens", new Author("Camilla", "Cyrino"))));
		Optional<BookUnit> bookUnit = Optional.of(bookUnits.get(0));

		Mockito.when(bookUnitRepository.findAll()).thenReturn(bookUnits);
		Mockito.when(bookUnitRepository.save(bookUnits.get(0))).thenReturn(bookUnits.get(0));
		Mockito.when(bookUnitRepository.findById(1l)).thenReturn(bookUnit);

	}

	@Test
	public void shouldReturnBooksList() {

		List<BookUnit> bookUnitsFound = bookService.getAllBookUnits();

		assertNotNull(bookUnitsFound);
		assertNotEquals(bookUnitsFound.size(), 0);
	}

	@Test
	public void shouldCreateBook() {

		BookDTO bookDTO = new BookDTO(new Book("Sapiens", new Author("Camilla", "Cyrino")), 5);
		List<BookUnit> bookUnitsCreated = bookService.createBook(bookDTO);

		assertNotNull(bookUnitsCreated);
		assertNotEquals(bookUnitsCreated.size(), 0);
		assertEquals(bookDTO.getQuantity(), bookUnitsCreated.size());

	}

	@Test
	public void shouldReserve() {
		bookService.reserve(1l);

		List<BookUnit> bookUnitsFound = bookService.getAllBookUnits();

		assertNotNull(bookUnitsFound);
		assertNotEquals(bookUnitsFound.size(), 0);
		assertEquals(bookUnitsFound.get(0).getStatus(), BookStatusEnum.RESERVED);
	}

}
