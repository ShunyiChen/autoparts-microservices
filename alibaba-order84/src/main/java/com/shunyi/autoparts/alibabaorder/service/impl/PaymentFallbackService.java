package com.shunyi.autoparts.alibabaorder.service.impl;

import com.shunyi.autoparts.alibabaorder.service.MyFeignService;
import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-25 10:53
 */
@Component
public class PaymentFallbackService implements MyFeignService {
    @Override
    public CommonResult<Payment> openfeign(Long id) {
        return new CommonResult<>(444, "服务降级返回----PaymentFallbackService", new Payment(id, "1001"));
    }
}
