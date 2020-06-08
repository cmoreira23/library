package com.camilla.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilla.library.model.Rental;
import com.camilla.library.repository.RentalRepository;

@Service
public class ClientService {

	@Autowired
	private RentalRepository repository;

	public List<Rental> getAll(Long id) {
		return this.repository.findByClientId(id);
	}

}
