package com.kontrakhukum.backendtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kontrakhukum.backendtest.model.Customer;
import com.kontrakhukum.backendtest.repository.CustomerRepository;
import com.kontrakhukum.backendtest.repository.OrderRepository;
import com.kontrakhukum.backendtest.repository.TicketRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KontrakhukumApplicationTests {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void whenInsertCustomer() {
		Customer cs = new Customer("name", "08788291212", "email@gmail.com");
		testEntityManager.persist(cs);
		testEntityManager.flush();
		
		Customer found = customerRepository.findByName(cs.getName());
		
		assertThat(found.getName()).isEqualTo(cs.getName());	
	}
	
}
