package com.shunyi.autoparts.alibabaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Simeon Chen
 *
 * @create 2021-01-13 11:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaOrderApp {
    public static void main(String[] arguments) {
        SpringApplication.run(AlibabaOrderApp.class, arguments);
    }
}
