package com.camilla.library.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.camilla.library.model.Rental;

/**
 * @author camilla
 *
 */
public interface RentalRepository extends JpaRepository<Rental, Long> {
	@Query("SELECT r FROM Rental r WHERE r.client.id = ?1 ")
	ArrayList<Rental> findByClientId(Long clientId);
}
