package com.shunyi.autoparts.configserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shunyi Chen
 * @create 2021-01-09 22:27
 */
@RestController
@RefreshScope  //支持Nacos动态刷新功能
public class AlibabaConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    //详细解释@Value https://www.hxstrive.com/article/854.htm
    @Value("#{systemProperties['os.name']}")
    private String osName; // 结果：Windows 10

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

    @GetMapping("/config/osName")
    public String getosName() {
        return osName;
    }
}
