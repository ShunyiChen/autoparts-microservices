package com.shunyi.autoparts.paymentsul.dao;

import com.shunyi.autoparts.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 22:46
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
