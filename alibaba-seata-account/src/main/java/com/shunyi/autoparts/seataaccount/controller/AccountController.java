package com.shunyi.autoparts.seataaccount.controller;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.seataaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 23:36
 */
@RestController
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/account/deduct")
    public CommonResult create(Long userId, BigDecimal money) {
        accountService.deduct(userId, money);
        log.info("********扣钱成功");
        return CommonResult.builder().code(200).message("插入数据库成功").build();
    }
}
