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
import com.camilla.library.model.Book;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	BookRepository repository;

	@Test
	public void shouldSaveBook() {
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

		List<Book> booksDB = repository.findAll();
		assertNotNull(booksDB);
		assertNotEquals(booksDB.size(), 0);
		assertEquals(booksDB.get(0).getAuthor(), book.getAuthor());
		assertEquals(booksDB.get(0).getTitle(), book.getTitle());
		assertEquals(booksDB.get(0).getSubTitle(), book.getSubTitle());
		assertEquals(booksDB.get(0).getContry(), book.getContry());
		assertEquals(booksDB.get(0).getPages(), book.getPages());

	}
}
