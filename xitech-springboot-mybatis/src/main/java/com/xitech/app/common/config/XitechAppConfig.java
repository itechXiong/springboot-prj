package com.xitech.app.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableCaching //开启缓存
@ComponentScan(basePackages={"com.xitech.app.portal.controller,com.xitech.app.portal.dao","com.xitech.app.rocketmq","com.xitech.app.zkconfig"})
@MapperScan(basePackages= {"com.xitech.app.portal.mapper"})
@ImportResource(value= {"classpath*:springboot/*.xml"})
public class XitechAppConfig {

}
