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

import com.camilla.library.model.Client;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	ClientRepository repository;

	@Test
	public void shouldSaveClient() {
		Client client = new Client();
		client.setName("Joao");
		client.setPhone("456521383");
		entityManager.persist(client);
		entityManager.flush();
		List<Client> clientDB = repository.findAll();
		assertNotNull(clientDB);
		assertNotEquals(clientDB.size(), 0);
		assertEquals(clientDB.get(0).getName(), client.getName());
		assertEquals(clientDB.get(0).getPhone(), client.getPhone());
	}
}
