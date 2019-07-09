package com.xitech.app.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages= {"com.xitech.app.controller"})
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
