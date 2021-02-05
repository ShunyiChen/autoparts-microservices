package com.shunyi.autoparts.seataorder.controller;

import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.seataorder.entity.Order;
import com.shunyi.autoparts.seataorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:36
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/seata/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        log.info("********创建order成功");
        return CommonResult.builder().code(200).message("插入order成功, server port="+serverPort).data(order).build();
    }
}
