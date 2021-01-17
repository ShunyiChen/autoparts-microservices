package com.shunyi.autoparts.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Simeon Chen
 *
 * @create 2021-01-13 11:33
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-----------testB";
    }
}