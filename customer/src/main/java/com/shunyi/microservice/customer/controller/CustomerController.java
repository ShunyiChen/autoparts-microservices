package com.shunyi.microservice.customer.controller;

import com.shunyi.microservice.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-CUSTOMER";

    @Autowired
    private RestTemplate restTemplate;


}
