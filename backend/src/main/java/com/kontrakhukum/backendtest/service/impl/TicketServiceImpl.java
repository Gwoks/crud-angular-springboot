package com.kontrakhukum.backendtest.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kontrakhukum.backendtest.model.Response;
import com.kontrakhukum.backendtest.model.Ticket;
import com.kontrakhukum.backendtest.repository.TicketRepository;
import com.kontrakhukum.backendtest.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTicket() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Optional<Ticket> getTicketById(Long id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id);
	}

	@Override
	public Ticket addTicket(@Valid Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public Response removeTicketById(Long id) {
		// TODO Auto-generated method stub
		Response response = new Response();
		Optional<Ticket> tick = ticketRepository.findById(id);
		response.setMessage(tick.isPresent() ? "deleted" : "id not found");
		return response;
	}

}
