package com.sonia.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.sonia.springcloud.dao"})
public class MybatisConfig {
}
