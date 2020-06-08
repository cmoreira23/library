package com.camilla.library.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
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
import com.camilla.library.model.Client;
import com.camilla.library.model.Rental;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RentalRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	RentalRepository repository;

	@Test
	public void shouldSaveRental() {
		Client client = new Client();
		client.setName("Joao");
		client.setPhone("456521383");
		entityManager.persist(client);
		entityManager.flush();
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

		Rental rental = new Rental();
		rental.setClient(client);
		rental.setBookUnit(bookUnit);
		rental.setRentalDate(new Date());

		entityManager.persist(rental);
		entityManager.flush();
		List<Rental> rentalDB = repository.findAll();
		assertNotNull(rentalDB);
		assertNotEquals(rentalDB.size(), 0);
		assertEquals(rentalDB.get(0).getClient(), rental.getClient());
		assertEquals(rentalDB.get(0).getBookUnit(), rental.getBookUnit());
		assertEquals(rentalDB.get(0).getRentalDate(), rental.getRentalDate());
	}
}
