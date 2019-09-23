package com.xitech.app.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;


@EnableAutoConfiguration
//@SpringBootApplication
public class XitechSpringBootDubboProviderApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(XitechSpringBootDubboProviderApp.class, args);
    	new SpringApplicationBuilder(XitechSpringBootDubboProviderApp.class).run(args);
    }
}
