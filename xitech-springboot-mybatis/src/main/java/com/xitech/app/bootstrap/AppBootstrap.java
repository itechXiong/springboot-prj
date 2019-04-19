package com.xitech.app.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *@ComponentScan(basePackages={"com.xitech"})
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.xitech.app.portal.controller,com.xitech.app.portal.dao"})
public class AppBootstrap {
	
	public static void main(String[] args) {
		 SpringApplication.run(AppBootstrap.class, args);
	}

}
