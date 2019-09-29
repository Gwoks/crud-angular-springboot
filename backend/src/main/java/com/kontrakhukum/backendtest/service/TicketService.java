package com.kontrakhukum.backendtest.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.kontrakhukum.backendtest.model.Response;
import com.kontrakhukum.backendtest.model.Ticket;

public interface TicketService {

	List<Ticket> getAllTicket();

	Optional<Ticket> getTicketById(Long id);

	Ticket addTicket(@Valid Ticket ticket);

	Response removeTicketById(Long id);

}
