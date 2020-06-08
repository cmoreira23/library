package com.camilla.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camilla.library.model.Author;

/**
 * @author camilla
 *
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
