package com.shunyi.autoparts.orderfeign.controller;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import com.shunyi.autoparts.orderfeign.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 * @create 2020-12-10 0:58
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("创建by openfeign");
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        log.info("查询by openfeign");
        return paymentFeignService.getPaymentById(id);
    }
}
