package com.shunyi.autoparts.paymenthystrix.service.impl;

import com.shunyi.autoparts.common.entities.Payment;
import com.shunyi.autoparts.paymenthystrix.dao.PaymentDao;
import com.shunyi.autoparts.paymenthystrix.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 23:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Long id) {
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_OK, id: "+id+"\n";
    }

    @Override
    public String paymentInfo_Timeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_Timeout（已超过3秒）, id: "+id+"\n";
    }

//    @Resource
//    private PaymentDao paymentDao;
//
//    @Override
//    public int create(Payment payment) {
//        return paymentDao.create(payment);
//    }
//
//    @Override
//    public Payment getPaymentById(Long id) {
//        return paymentDao.getPaymentById(id);
//    }
}
