package com.shunyi.autoparts.alibabapayment.service.impl;

import com.shunyi.autoparts.alibabapayment.dao.PaymentDao;
import com.shunyi.autoparts.alibabapayment.service.PaymentService;
import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
