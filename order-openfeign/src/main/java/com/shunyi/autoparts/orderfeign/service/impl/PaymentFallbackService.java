package com.shunyi.autoparts.orderfeign.service.impl;

import com.shunyi.autoparts.orderfeign.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author Asus
 * @create 2020-12-23 22:53
 */
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "PaymentFallbackService ok fallback";
    }

    @Override
    public String paymentInfo_Timeout(Long id) {
        return "PaymentFallbackService timeout fallback";
    }

    @Override
    public String paymentInfoCircuitBreaker(Long id) {
        return "PaymentFallbackService Circuit Breaker";
    }
}
