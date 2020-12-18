package com.shunyi.autoparts.paymentsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Shunyi Chen
 * @create 2020-12-11 23:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentAppForConsul {

	public static void main(String[] args) {
		SpringApplication.run(PaymentAppForConsul.class, args);
	}

}
