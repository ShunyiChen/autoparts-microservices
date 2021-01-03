package com.shunyi.autoparts.rabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Shunyi Chen
 * @create 2021-01-03 23:50
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitmqConsumer {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumer.class, args);
    }
}
