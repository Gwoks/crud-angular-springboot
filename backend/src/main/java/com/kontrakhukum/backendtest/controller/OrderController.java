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

import com.kontrakhukum.backendtest.model.Order;
import com.kontrakhukum.backendtest.model.Response;
import com.kontrakhukum.backendtest.service.OrderService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long id) {
		Optional<Order> order = orderService.getOrderById(id);
		return order.isPresent() ? ResponseEntity.ok().body(order.get()) : ResponseEntity.notFound().build();

	}

	@PostMapping("/")
	public Response addOrder(@Valid @RequestBody Order order) {
		return orderService.addOrder(order);
	}

	@DeleteMapping("/{id}")
	public Response deleteOrder(@PathVariable(value = "id") Long id) {
		return orderService.removeOrderById(id);
	}

}
