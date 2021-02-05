package com.shunyi.autoparts.seataaccount.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.shunyi.autoparts.seataaccount.dao"})
public class MyBatisConfig {
}
