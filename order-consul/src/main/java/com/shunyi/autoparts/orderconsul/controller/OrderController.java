package com.shunyi.autoparts.orderconsul.controller;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    /** zookeeper 服务注册名称 */
    public static final String PAYMENT_URL = "http://payment-consul";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("创建create1");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id) {
        log.info("查询get1");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get2/{id}")
    public CommonResult<Payment> get2(@PathVariable("id") Long id) {
        log.info("查询get2");
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败", null);
        }
    }
}
