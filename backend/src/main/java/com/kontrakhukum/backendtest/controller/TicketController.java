package com.kontrakhukum.backendtest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kontrakhukum.backendtest.model.Response;
import com.kontrakhukum.backendtest.model.Ticket;
import com.kontrakhukum.backendtest.service.TicketService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/")
	public List<Ticket> getAllTicket() {
		return ticketService.getAllTicket();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") Long id) {
		Optional<Ticket> ticket = ticketService.getTicketById(id);
		return ticket.isPresent() ? ResponseEntity.ok().body(ticket.get()) : ResponseEntity.notFound().build();

	}

	@PostMapping("/")
	public Ticket addTicket(@Valid @RequestBody Ticket ticket) {
		return ticketService.addTicket(ticket);
	}

	@DeleteMapping("/{id}")
	public Response deleteTicket(@PathVariable(value = "id") Long id) {
		return ticketService.removeTicketById(id);
	}
}
