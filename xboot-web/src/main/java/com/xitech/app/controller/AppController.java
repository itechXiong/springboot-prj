package com.xitech.app.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@Scheduled(cron="0/10 * * * * *")
	public void print() {
		
		System.out.println("当前时间："+ System.currentTimeMillis());
	}
}
