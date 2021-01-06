package com.shunyi.autoparts.payment.controller;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import com.shunyi.autoparts.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 23:36
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private EurekaDiscoveryClient discoveryClient;

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

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(e -> {
            log.info("*************element: "+e);
        });

        List<ServiceInstance> inst = discoveryClient.getInstances("PAYMENT-APP");
        inst.forEach(e -> {
            log.info(e.getInstanceId()+"\t"+e.getHost()+"\t"+e.getPort()+"\t"+e.getUri());
        });

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "Hi, I am paymentzipkin server fall back, welcome!!";
    }
}
