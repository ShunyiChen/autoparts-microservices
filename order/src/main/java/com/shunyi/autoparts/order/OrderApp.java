package com.shunyi.autoparts.order;

import com.shunyi.autoparts.order.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.io.FileInputStream;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
@RibbonClient(name="PAYMENT-APP", configuration = MySelfRule.class)
public class OrderApp {

	public static void main(String[] args) {

		FileInputStream fis;


		SpringApplication.run(OrderApp.class, args);
	}

}
