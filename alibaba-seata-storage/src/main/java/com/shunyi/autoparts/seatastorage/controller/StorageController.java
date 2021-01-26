package com.shunyi.autoparts.seatastorage.controller;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.seatastorage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 23:36
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/storage/deduct")
    public CommonResult deduct(Long productId, Integer count) {
        storageService.deduct(productId, count);
        return CommonResult.builder().code(200).message("扣减storage数据库成功").build();
    }
}
