package com.xitech.app.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableHystrix//开启hystrix
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages= {"com.xitech.app.hystrix"})
public class XitechSpringcloudHystrixApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(XitechSpringcloudHystrixApp.class, args);
    }
}
