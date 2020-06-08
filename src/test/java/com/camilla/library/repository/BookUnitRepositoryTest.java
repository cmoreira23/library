package com.camilla.library.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.camilla.library.enumerate.BookStatusEnum;
import com.camilla.library.model.Author;
import com.camilla.library.model.Book;
import com.camilla.library.model.BookUnit;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookUnitRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	BookUnitRepository repository;

	@Test
	public void shouldSaveBookUnit() {
		Author author = new Author();
		author.setFirstName("Camilla");
		author.setLastName("Cyrino");
		entityManager.persist(author);
		entityManager.flush();

		Book book = new Book();
		book.setTitle("Sapiens");
		book.setSubTitle("Uma breve história da humanidade");
		book.setAuthor(author);
		book.setContry("USA");
		book.setPages(510);
		entityManager.persist(book);
		entityManager.flush();

		BookUnit bookUnit = new BookUnit();
		bookUnit.setBook(book);
		bookUnit.setStatus(BookStatusEnum.AVAILABLE);
		entityManager.persist(bookUnit);
		entityManager.flush();

		List<BookUnit> bookUnitDB = repository.findAll();
		assertNotNull(bookUnitDB);
		assertNotEquals(bookUnitDB.size(), 0);
		assertEquals(bookUnitDB.get(0).getBook(), bookUnit.getBook());
		assertEquals(bookUnitDB.get(0).getStatus(), bookUnit.getStatus());

	}
}
