package com.shunyi.autoparts.orderfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Shunyi Chen
 * @create 2020-12-20 21:36
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrderAppForFeign {

	public static void main(String[] args) {
		SpringApplication.run(OrderAppForFeign.class, args);
	}

}
