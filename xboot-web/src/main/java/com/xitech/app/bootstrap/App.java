package com.xitech.app.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
@EnableCaching //开启缓存
@ComponentScan(basePackages = { "com.xitech.app.controller","com.xitech.app.bootstrap" })
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
