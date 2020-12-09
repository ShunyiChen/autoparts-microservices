package com.shunyi.autoparts.payment.controller;

import com.shunyi.autoparts.payment.entities.CommonResult;
import com.shunyi.autoparts.payment.entities.Payment;
import com.shunyi.autoparts.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 23:36
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果："+result);
        if(result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(500, "插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果："+payment);
        if(payment != null) {
            return new CommonResult(200, "查询成功！！！", payment);
        } else {
            return new CommonResult(500, "查询失败，查询ID:"+id);
        }
    }
}
