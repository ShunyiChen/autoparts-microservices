package com.shunyi.autoparts.configconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServerAppForConsul {

    public static void main(String[] arguments) {
        SpringApplication.run(ConfigServerAppForConsul.class, arguments);
    }
}
