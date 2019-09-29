package com.kontrakhukum.backendtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kontrakhukum.backendtest.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
