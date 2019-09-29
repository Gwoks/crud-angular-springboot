package com.kontrakhukum.backendtest.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.kontrakhukum.backendtest.model.Customer;
import com.kontrakhukum.backendtest.model.Response;

public interface CustomerService {

	List<Customer> getAllCustomer();

	Optional<Customer> getById(Long id);

	Customer addCustomer(@Valid Customer customer);

	Response removeCustomerById(Long id);

}
