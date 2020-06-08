package com.camilla.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camilla.library.model.Client;

/**
 * @author camilla
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
