package com.xitech.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XitechEurekaServerApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(XitechEurekaServerApp.class, args);
    }
}
