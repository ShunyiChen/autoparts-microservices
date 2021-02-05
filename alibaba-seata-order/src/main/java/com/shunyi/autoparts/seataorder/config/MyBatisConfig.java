package com.shunyi.autoparts.seataorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.shunyi.autoparts.seataorder.dao"})
public class MyBatisConfig {
}
