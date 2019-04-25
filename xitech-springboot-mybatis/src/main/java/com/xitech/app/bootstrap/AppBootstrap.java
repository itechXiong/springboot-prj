package com.xitech.app.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *@ComponentScan(basePackages={"com.xitech"})
 */
@SpringBootApplication
@EnableDiscoveryClient	
@ComponentScan(basePackages={"com.xitech.app.common.config"})
public class AppBootstrap {
	
	public static void main(String[] args) {
		 SpringApplication.run(AppBootstrap.class, args);
	}

}
