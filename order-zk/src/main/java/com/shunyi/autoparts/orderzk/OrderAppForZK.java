package com.shunyi.autoparts.orderzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderAppForZK {

	public static void main(String[] args) {
		SpringApplication.run(OrderAppForZK.class, args);
	}

}
