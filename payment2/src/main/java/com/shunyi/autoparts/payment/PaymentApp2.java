package com.shunyi.autoparts.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient("order")
public class PaymentApp2 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApp2.class, args);
	}
}
