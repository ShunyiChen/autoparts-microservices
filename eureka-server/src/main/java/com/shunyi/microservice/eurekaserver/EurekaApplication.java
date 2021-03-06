package com.shunyi.microservice.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Shunyi Chen
 * @create 2020-12-11 23:48
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		System.out.println("热部署已开启1");
		SpringApplication.run(EurekaApplication.class, args);
	}

}
