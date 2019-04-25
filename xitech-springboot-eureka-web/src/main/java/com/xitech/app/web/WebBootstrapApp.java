package com.xitech.app.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages= {"com.xitech.app.web.controller","com.xitech.app.web.config"})
@EnableDiscoveryClient
public class WebBootstrapApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(WebBootstrapApp.class, args);
    }
}
