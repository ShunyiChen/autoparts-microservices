package com.shunyi.autoparts.order.controller;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 * @create 2020-12-10 0:58
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://PAYMENT-APP";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("创建");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id) {
        log.info("查询");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    /**
     * 链路调用 sleuth + zipkin
     * */
    @GetMapping(value = "/consumer/payment/zipkin")
    public String zipkin() {
        log.info("zipkin");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin", String.class);
    }
}
