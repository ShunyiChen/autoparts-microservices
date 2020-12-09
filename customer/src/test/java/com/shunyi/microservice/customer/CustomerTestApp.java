package com.shunyi.microservice.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CustomerTestApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomerTestApp.class);
		app.setAdditionalProfiles("test");
		app.run(args);
	}

}
