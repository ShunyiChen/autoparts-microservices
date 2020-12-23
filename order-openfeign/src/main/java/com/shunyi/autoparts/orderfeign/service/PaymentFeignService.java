package com.shunyi.autoparts.orderfeign.service;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(contextId = "client1", value = "PAYMENT-APP")
public interface PaymentFeignService {

    /**
     * Create payment
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    CommonResult create(@RequestBody Payment payment);

    /**
     * Find payment by id
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * Payment timeout
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
