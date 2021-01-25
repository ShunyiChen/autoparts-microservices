package com.shunyi.autoparts.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-13 11:33
 */
@RestController
@Slf4j
public class FlowLimitController {

    /** 按QPS限制（御敌挡之门外） */
    @GetMapping("/testA")
    public String testA() {
        return "-----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"*****"+"testB");
        return "-----------testB";
    }

    /** 按线程数限制（随便冲进来，关门打狗） */
    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-----------testC";
    }

    /** 测试RT平均响应时间 */
    @GetMapping("/testD")
    public String testD() {
        try {
            //慢调用， 如果慢调用比例过于0.1则熔断
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info(Thread.currentThread().getName()+"*****"+"testD");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-----------test RT";
    }

    /** 测试异常比例 */
    @GetMapping("/testE")
    public String testE() {
        log.info(Thread.currentThread().getName()+"*****"+"testE");
        int age = 10 / 0;
        return "-----------test 异常比例";
    }

    /** 测试异常数 */
    @GetMapping("/testF")
    public String testF() {
        log.info(Thread.currentThread().getName()+"*****"+"testF");
        int age = 10 / 0;
        return "-----------test 异常数";
    }

    @GetMapping("/testhotspot")
    @SentinelResource(value = "testhotspot", blockHandler = "test_hotspot") // 如果不指定test_hotspot，页面出现error页面
    public String testHotspot(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return "test hotspot successfully";
    }

    /**
     * 兜底方法
     * @param p1
     * @param p2
     * @param blockException
     * @return
     */
    public String test_hotspot(String p1, String p2, BlockException blockException) {
        return "testHotspot（）执行失败了,第0个参数 超过QPS=1！";
    }
}
