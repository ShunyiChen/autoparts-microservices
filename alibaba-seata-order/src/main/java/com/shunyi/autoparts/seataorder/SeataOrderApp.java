package com.shunyi.autoparts.seataorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-13 11:34
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderApp {
    public static void main(String[] arguments) {
        SpringApplication.run(SeataOrderApp.class, arguments);
    }
}
