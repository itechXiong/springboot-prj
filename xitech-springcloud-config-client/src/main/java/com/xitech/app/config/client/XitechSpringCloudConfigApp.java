package com.xitech.app.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XitechSpringCloudConfigApp 
{
    public static void main( String[] args )
    {
       SpringApplication.run(XitechSpringCloudConfigApp.class, args);
    }
}
