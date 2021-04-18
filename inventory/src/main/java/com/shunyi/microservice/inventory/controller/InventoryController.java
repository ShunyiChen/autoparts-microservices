package com.shunyi.microservice.inventory.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    /** 测试异常数 */
    @GetMapping("/testF")
    @CrossOrigin
    public String testF() {
        return "-----------test 异常数123";
    }
}
