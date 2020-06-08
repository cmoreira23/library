package com.camilla.library.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.camilla.library.enumerate.BookStatusEnum;
import com.camilla.library.model.Author;
import com.camilla.library.model.Book;
import com.camilla.library.model.BookUnit;
import com.camilla.library.model.Client;
import com.camilla.library.model.Rental;
import com.camilla.library.repository.RentalRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	@MockBean
	private RentalRepository rentalRepository;

	@Before
	public void setUp() {

		ArrayList<Rental> rentals = new ArrayList<Rental>();
		rentals.add(
				new Rental(new BookUnit(BookStatusEnum.BORROWED, new Book("Sapiens", new Author("Camilla", "Cyrino"))),
						new Client("João", "45648456"), new Date()));
		Mockito.when(rentalRepository.findByClientId(1l)).thenReturn(rentals);
	}

	@Test
	public void shouldReturnRentalListByClientId() {
		List<Rental> rentalsFound = clientService.getAll(1l);

		assertNotNull(rentalsFound);
		assertNotEquals(rentalsFound.size(), 0);
	}
}
