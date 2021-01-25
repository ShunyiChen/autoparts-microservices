package com.shunyi.autoparts.alibabaorder.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shunyi.autoparts.alibabaorder.service.MyFeignService;
import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 * @create 2021-01-21 22:56
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://alibaba-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyFeignService service;


    @GetMapping(value = "/consumer/fallback/{id}")
    //第一种情况：如果不配置@SentinelResource(value = "fallback")，当参数为0直接显示错误页面对用户很不友好
    //第二种情况: 用fallback处理异常@SentinelResource(value = "fallback", fallback = "handlerFallback")
    //第三种情况: 管sentinel控制台违规用@SentinelResource(value = "fallback", blockHandler = "blockHandler")
    //第四种情况: 既管fallback同时管sentinel控制台违规用@SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback")
    //第五种情况: 遇到IllegalArgumentException则忽略不走fallbackHandler 用@SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback", exceptionsToIgnore = {IllegalArgumentException.class})
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+"/payment/get/"+id, CommonResult.class);
        if(id == 0) {
            throw new IllegalArgumentException("非法参数异常,id不能等于0");
        } else if(result.getData() == null) {
            throw new IllegalArgumentException("没有找到id等于"+id+"的记录");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e) {
        return new CommonResult(444, "兜底处理："+"\t服务不可用fallback", new Payment(id, null));
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        return new CommonResult(444, "兜底处理："+"\t服务不可用block handler\t"+blockException.getMessage(), new Payment(id, null));
    }


    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> callOpenfeign(@PathVariable("id") Long id) {
        return service.openfeign(id);
    }
}
