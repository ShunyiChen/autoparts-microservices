package com.shunyi.autoparts.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import com.shunyi.autoparts.sentinel.handler.CustomBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shunyi Chen
 * @create 2021-01-19 9:08
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return CommonResult.builder().code(200).message("按资源名称限流OK").data(new Payment(2021L, "serial112")).build();
    }

    public CommonResult handleException(BlockException blockException) {
        return CommonResult.builder().code(444).message(blockException.getClass().getCanonicalName()+"\t服务不可用").build();
    }

    @GetMapping("/ratelimit/byurl")
    @SentinelResource(value = "byurl", blockHandler = "handlerException2", blockHandlerClass = CustomBlockHandler.class)
    public CommonResult byUrl() {
        return CommonResult.builder().code(200).message("按URL限流OK").data(new Payment(2022L, "serial112")).build();
    }
}
