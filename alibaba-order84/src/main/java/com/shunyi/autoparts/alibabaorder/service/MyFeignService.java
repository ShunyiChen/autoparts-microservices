package com.shunyi.autoparts.alibabaorder.service;

import com.shunyi.autoparts.alibabaorder.service.impl.PaymentFallbackService;
import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-25 11:34
 */
@FeignClient(value = "alibaba-payment-provider", fallback = PaymentFallbackService.class)
public interface MyFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> openfeign(@PathVariable("id") Long id);
}
