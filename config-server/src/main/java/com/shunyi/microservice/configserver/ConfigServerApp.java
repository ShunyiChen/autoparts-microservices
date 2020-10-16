package com.shunyi.microservice.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp {

    public static void main(String[] arguments) {
        SpringApplication.run(ConfigServerApp.class, arguments);
    }
}
