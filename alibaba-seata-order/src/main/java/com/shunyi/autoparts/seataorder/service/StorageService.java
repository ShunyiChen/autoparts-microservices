package com.shunyi.autoparts.seataorder.service;

import com.shunyi.autoparts.common.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-26 23:32
 */
@FeignClient(value = "alibaba-seata-storage")
public interface StorageService {

    @PostMapping(value="/storage/deduct")
    CommonResult deduct(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
