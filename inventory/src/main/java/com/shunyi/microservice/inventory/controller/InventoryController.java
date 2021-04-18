package com.shunyi.microservice.inventory.controller;

import com.alibaba.fastjson.JSON;
import com.shunyi.autoparts.common.entities.CommonResult;
import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class InventoryController {

    private Map<String, CommonResult> map = new HashMap<>();

    /** 测试异常数 */
    @GetMapping("/testF")
    @CrossOrigin
    public String testF() {
        return "-----------test 异常数123";
    }

    @PostMapping(value = "/testF/create")
    @CrossOrigin
    public String create(@RequestBody Payment payment) {
        return "插入成功";
    }
}
