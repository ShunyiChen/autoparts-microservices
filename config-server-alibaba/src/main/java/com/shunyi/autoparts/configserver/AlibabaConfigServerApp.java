package com.shunyi.autoparts.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConfigServerApp {

    public static void main(String[] arguments) {
        SpringApplication.run(AlibabaConfigServerApp.class, arguments);
    }
}
