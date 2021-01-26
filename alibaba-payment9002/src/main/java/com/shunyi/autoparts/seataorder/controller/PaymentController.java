package com.shunyi.autoparts.seataorder.controller;

import com.shunyi.autoparts.seataorder.service.PaymentService;
import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果："+result);
        if(result > 0) {
            return CommonResult.builder().code(200).message("插入数据库成功, server port="+serverPort+", result="+result).data(null).build();
        } else {
            return CommonResult.builder().code(500).message("插入数据库失败").data(null).build();
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果："+payment);
        if(payment != null) {
            return new CommonResult(200, "查询成功, server port="+serverPort, payment);
        } else {
            return CommonResult.builder().code(500).message("查询失败，查询ID:"+id).data(null).build();
        }
    }

}
