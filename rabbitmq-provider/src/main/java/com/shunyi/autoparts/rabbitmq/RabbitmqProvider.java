package com.shunyi.autoparts.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Shunyi Chen
 * @create 2021-01-03 23:16
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitmqProvider {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProvider.class, args);
    }
}
