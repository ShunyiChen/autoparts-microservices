package com.shunyi.autoparts.payment.service;

import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.data.repository.query.Param;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 23:32
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
