package com.shunyi.autoparts.orderfeign.service;

import com.shunyi.autoparts.orderfeign.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(contextId = "client2", value = "PAYMENT-APP",fallback = PaymentFallbackService.class)
public interface PaymentFeignHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentInfoCircuitBreaker(@PathVariable("id") Long id);
}
