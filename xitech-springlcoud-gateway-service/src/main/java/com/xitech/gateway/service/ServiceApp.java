package com.xitech.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan(basePackages= {"com.xitech.gateway.service"})
public class ServiceApp 
{
    public static void main( String[] args )
    {
       	SpringApplication.run(ServiceApp.class, args);
    }
}
