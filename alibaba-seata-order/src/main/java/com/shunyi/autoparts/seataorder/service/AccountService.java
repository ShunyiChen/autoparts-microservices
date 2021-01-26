package com.shunyi.autoparts.seataorder.service;

import com.shunyi.autoparts.common.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-26 14:46
 */
@Service
@FeignClient(value = "alibaba-seata-account")
public interface AccountService {

    @PostMapping(value="/account/deduct")
    CommonResult deduct(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
