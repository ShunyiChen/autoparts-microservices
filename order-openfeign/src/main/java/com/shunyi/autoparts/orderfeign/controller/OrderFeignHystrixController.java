package com.shunyi.autoparts.orderfeign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shunyi.autoparts.orderfeign.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 * @create 2020-12-10 0:58
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_GlobalFallbackMethod")
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id) {
        return paymentFeignHystrixService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
            commandProperties = @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000"))
    public String paymentInfo_Timeout(@PathVariable("id") Long id) {
//        int age = 10/0;
        return paymentFeignHystrixService.paymentInfo_Timeout(id);
    }

    // 使用通用fallback方法
    @GetMapping(value = "/consumer/payment/hystrix/timeout2/{id}")
    @HystrixCommand
    public String paymentInfo_Timeout2(@PathVariable("id") Long id) {
//        int age = 10/0;
        return paymentFeignHystrixService.paymentInfo_Timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Long id) {
        return "我是消费端，当前服务繁忙，请稍后再试！ 线程池: "+Thread.currentThread().getName()+"  paymentInfo_Timeout（ 兜底）, id: "+id+"\n";
    }

    public String paymentInfo_GlobalFallbackMethod() {
        return "我是消费端，当前服务繁忙，请稍后再试！ 线程池: "+Thread.currentThread().getName()+"  paymentInfo_Timeout（ 全局兜底）";
    }

    //服务熔断
    // 使用通用fallback方法
    @GetMapping(value = "/consumer/payment/hystrix/breaker/{id}")
    @HystrixCommand
    public String paymentInfoCircuitBreaker(@PathVariable("id") Long id) {
        return paymentFeignHystrixService.paymentInfoCircuitBreaker(id);
    }
}
