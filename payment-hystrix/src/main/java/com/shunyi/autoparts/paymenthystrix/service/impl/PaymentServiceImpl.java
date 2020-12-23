package com.shunyi.autoparts.paymenthystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shunyi.autoparts.common.entities.Payment;
import com.shunyi.autoparts.paymenthystrix.dao.PaymentDao;
import com.shunyi.autoparts.paymenthystrix.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.UUID;
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

    // 服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
            commandProperties = @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000"))
    @Override
    public String paymentInfo_Timeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int age = 10 / 0;
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_Timeout（已超过4秒）, id: "+id+"\n";
    }

    public String paymentInfo_TimeoutHandler(Long id) {
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_Timeout（ 兜底）, id: "+id+"\n";
    }

    //服务断熔
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if(id < 0) {
            throw new RuntimeException("********id不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return "线程池： "+Thread.currentThread().getName()+"  调用成功，流水号: "+serialNumber+"\n";
    }

    public String paymentCircuitBreaker_fallback(Long id) {
        return "id 不能为负数，请稍后再试  id="+id;
    }
}
