package com.shunyi.autoparts.paymenthystrix.service;

import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 23:32
 */
public interface PaymentService {

//    int create(Payment payment);
//
//    Payment getPaymentById(@Param("id") Long id);

    /**
     * 正常访问，肯定OK
     *
     * @param id
     * @return
     */
    String paymentInfo_OK(Long id);

    /**
     * 超时访问，不OK
     *
     * @param id
     * @return
     */
    String paymentInfo_Timeout(Long id);


    /**
     * 服务断熔
     * @param id
     * @return
     */
   String paymentCircuitBreaker(Long id);
}
