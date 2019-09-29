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

import com.kontrakhukum.backendtest.model.Customer;
import com.kontrakhukum.backendtest.model.Response;
import com.kontrakhukum.backendtest.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long id) {
		Optional<Customer> customer = customerService.getById(id);
		return customer.isPresent() ? ResponseEntity.ok().body(customer.get()) : ResponseEntity.notFound().build();

	}

	@PostMapping("/")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@DeleteMapping("/{id}")
	public Response deleteCustomer(@PathVariable(value = "id") Long id) {
		return customerService.removeCustomerById(id);
	}

}
