package com.shunyi.microservice.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
@RibbonClient("customer")
public class CustomerApp {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApp.class, args);
	}

}
