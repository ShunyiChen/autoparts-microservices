package com.shunyi.microservice.inventory.controller;

import com.shunyi.autoparts.common.entities.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class InventoryController {

    /** 测试异常数 */
    @GetMapping("/testF")
    @CrossOrigin
    public String testF() {
        return "-----------test 异常数123";
    }


    /** 测试异常数 */
    @GetMapping("/testG")
    @CrossOrigin
    public String testG() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "-----------test 异常数123";
    }

    @PostMapping(value = "/testF/create")
    @CrossOrigin
    public String create(@RequestBody Payment payment) {
        return "插入成功";
    }
}
