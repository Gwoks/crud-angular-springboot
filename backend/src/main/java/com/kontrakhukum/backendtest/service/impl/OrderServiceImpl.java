package com.kontrakhukum.backendtest.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kontrakhukum.backendtest.model.Order;
import com.kontrakhukum.backendtest.model.Response;
import com.kontrakhukum.backendtest.model.Ticket;
import com.kontrakhukum.backendtest.repository.OrderRepository;
import com.kontrakhukum.backendtest.repository.TicketRepository;
import com.kontrakhukum.backendtest.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService	{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> getOrderById(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}

	@Override
	public Response addOrder(@Valid Order order) {
		// TODO Auto-generated method stub
		Response response = new Response();
		Optional<Ticket> ticket = ticketRepository.findById(order.getTicketId());
		if(ticket.isPresent() 	&& ticket.get().getQuantity() >= order.getBuy()) {
			ticket.get().setQuantity(ticket.get().getQuantity() - order.getBuy());
			
			ticketRepository.save(ticket.get());
			
			orderRepository.save(order);
			
			response.setMessage("sukses membeli tiket");
			return response;
		}
		response.setMessage("tiket tidak ditemukan atau sisa tiket yang tersedia kurang");
		return response;
	}

	@Override
	public Response removeOrderById(Long id) {
		// TODO Auto-generated method stub
		Response response = new Response();
		Optional<Order> cust = orderRepository.findById(id);
		response.setMessage(cust.isPresent() ? "deleted" : "id not found");
		return response;
	}

}
