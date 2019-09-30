package com.kontrakhukum.backendtest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.kontrakhukum.backendtest.model.Customer;
import com.kontrakhukum.backendtest.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest()
@SpringBootTest
public class KontrakhukumApplicationTests {

	@Autowired
	private MockMvc mock;

	@MockBean
	private CustomerService customerService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getCustomer() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/customer").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.customer").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customer[*].customerId").isNotEmpty());

	}

	@Test
	public void getCustomerById() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/customer/{id}", 1).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(1));
	}

}
