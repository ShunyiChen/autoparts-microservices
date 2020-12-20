package com.shunyi.autoparts.orderconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderAppForConsul {

	public static void main(String[] args) {
		SpringApplication.run(OrderAppForConsul.class, args);
	}

}
