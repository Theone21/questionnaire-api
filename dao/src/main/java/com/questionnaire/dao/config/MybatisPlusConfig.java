package com.questionnaire.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.questionnaire.dao.mapper")
public class MybatisPlusConfig {

}
