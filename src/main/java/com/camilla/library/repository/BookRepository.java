package com.camilla.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camilla.library.model.Book;

/**
 * @author camilla
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
