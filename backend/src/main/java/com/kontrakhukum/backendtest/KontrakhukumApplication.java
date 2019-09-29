package com.kontrakhukum.backendtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KontrakhukumApplication {

	public static void main(String[] args) {
		SpringApplication.run(KontrakhukumApplication.class, args);
	}

}
