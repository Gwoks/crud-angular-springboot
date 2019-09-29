package com.kontrakhukum.backendtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kontrakhukum.backendtest.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
