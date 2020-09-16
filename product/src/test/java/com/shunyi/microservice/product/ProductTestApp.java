package com.shunyi.microservice.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ProductTestApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProductTestApp.class);
		app.setAdditionalProfiles("test");
		app.run(args);
	}

}
