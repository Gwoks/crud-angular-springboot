package com.kontrakhukum.backendtest.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kontrakhukum.backendtest.model.Customer;
import com.kontrakhukum.backendtest.model.Response;
import com.kontrakhukum.backendtest.model.Ticket;
import com.kontrakhukum.backendtest.repository.CustomerRepository;
import com.kontrakhukum.backendtest.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

	@Override
	public Customer addCustomer(@Valid Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Response removeCustomerById(Long id) {
		// TODO Auto-generated method stub
		Response response = new Response();
		Optional<Customer> cust = customerRepository.findById(id);
		response.setMessage(cust.isPresent() ? "deleted" : "id not found");
		return response;
	}

}
