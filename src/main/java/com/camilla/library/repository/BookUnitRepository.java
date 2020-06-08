package com.camilla.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camilla.library.model.BookUnit;

/**
 * @author camilla
 *
 */
public interface BookUnitRepository extends JpaRepository<BookUnit, Long> {

}
