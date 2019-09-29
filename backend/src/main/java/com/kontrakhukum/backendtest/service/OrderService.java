package com.kontrakhukum.backendtest.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.kontrakhukum.backendtest.model.Order;
import com.kontrakhukum.backendtest.model.Response;

public interface OrderService {

	List<Order> getAllOrder();

	Optional<Order> getOrderById(Long id);

	Response addOrder(@Valid Order order);

	Response removeOrderById(Long id);

}
