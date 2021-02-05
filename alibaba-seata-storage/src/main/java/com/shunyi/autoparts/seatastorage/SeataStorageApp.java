package com.shunyi.autoparts.seatastorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-13 11:34
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@EnableDiscoveryClient
public class SeataStorageApp {
    public static void main(String[] arguments) {
        SpringApplication.run(SeataStorageApp.class, arguments);
    }
}
