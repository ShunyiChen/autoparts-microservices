package com.shunyi.autoparts.seatastorage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.shunyi.autoparts.seatastorage.dao"})
public class MyBatisConfig {
}
