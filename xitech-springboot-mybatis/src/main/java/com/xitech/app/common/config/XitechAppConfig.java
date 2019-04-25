package com.xitech.app.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.xitech.app.portal.controller,com.xitech.app.portal.dao"})
@MapperScan(basePackages= {"com.xitech.app.portal.mapper"})
@ImportResource(value= {"classpath*:springboot/*.xml"})
public class XitechAppConfig {

}
