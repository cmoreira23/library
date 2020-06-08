package com.camilla.library.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.camilla.library.model.BookUnit;
import com.camilla.library.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author camilla
 *
 */
@RestController
@Api(value = "EndPoint Books")
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	@ApiOperation(value = "Return all bookUnits", response = BookUnit.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in fetching the list") })
	@GetMapping()
	public List<BookUnit> getAll() {
		return this.service.getAllBookUnits();

	}

	@ApiOperation(value = "Reserve a book", response = void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in reserve the book"),
			@ApiResponse(code = 401, message = "Error reserve book, not found book by id") })
	@GetMapping(value = "/{id}/reserve")
	public void reserve(@ApiParam(value = "ID", required = true) @PathParam(value = "id") Long id)
			throws RestClientException {
		this.service.reserve(id);
	}

}
