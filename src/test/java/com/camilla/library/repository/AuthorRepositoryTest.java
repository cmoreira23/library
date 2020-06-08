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

import com.camilla.library.model.Author;
import com.camilla.library.repository.AuthorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	AuthorRepository repository;

	@Test
	public void shouldSaveAuthor() {
		Author author = new Author("Camilla", "Cyrino");

		entityManager.persist(author);
		entityManager.flush();

		List<Author> authorsDB = repository.findAll();
		assertNotNull(authorsDB);
		assertNotEquals(authorsDB.size(), 0);
		assertEquals(authorsDB.get(0).getFirstName(), author.getFirstName());
		assertEquals(authorsDB.get(0).getLastName(), author.getLastName());
	}
}
