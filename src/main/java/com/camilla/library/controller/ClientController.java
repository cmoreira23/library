package com.camilla.library.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.camilla.library.model.BookUnit;
import com.camilla.library.model.Rental;
import com.camilla.library.service.ClientService;

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
@Api(value = "EndPoint Client")
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService service;

	@ApiOperation(value = "Return all books of client", response = Rental.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success in fetching the list") })
	@GetMapping(value = "/{id_client}/books")
	public List<Rental> getAll(@ApiParam(value = "ID", required = true) @PathParam(value = "id_client") Long id)
			throws RestClientException {
		return this.service.getAll(id);
	}
}
