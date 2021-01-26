package com.shunyi.autoparts.seataaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-13 11:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataAccountApp {
    public static void main(String[] arguments) {
        SpringApplication.run(SeataAccountApp.class, arguments);
    }
}
