package com.shunyi.autoparts.paymentzk.service.impl;

import com.shunyi.autoparts.common.entities.Payment;
import com.shunyi.autoparts.paymentzk.dao.PaymentDao;
import com.shunyi.autoparts.paymentzk.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
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
