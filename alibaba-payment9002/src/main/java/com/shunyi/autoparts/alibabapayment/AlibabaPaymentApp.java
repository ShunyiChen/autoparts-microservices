package com.shunyi.autoparts.alibabapayment;

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
public class AlibabaPaymentApp {
    public static void main(String[] arguments) {
        SpringApplication.run(AlibabaPaymentApp.class, arguments);
    }
}
