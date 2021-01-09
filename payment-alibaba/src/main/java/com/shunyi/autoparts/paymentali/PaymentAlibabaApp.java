package com.shunyi.autoparts.paymentali;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shunyi Chen
 * @create 2021-01-07 11:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentAlibabaApp {

    public static void main(String[] args) {
        SpringApplication.run(PaymentAlibabaApp.class, args);
    }

    @RestController
    class EchoController {
        @Value("${server.port}")
        private String serverPort;

        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return string+"  server port:"+serverPort;
        }
    }
}
