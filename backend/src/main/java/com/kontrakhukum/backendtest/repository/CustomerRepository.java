package com.kontrakhukum.backendtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kontrakhukum.backendtest.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByName(String name);

}
