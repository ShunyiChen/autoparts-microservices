package com.shunyi.autoparts.paymenthystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentAppForHystrix {

	public static void main(String[] args) {
		SpringApplication.run(PaymentAppForHystrix.class, args);
	}
}
