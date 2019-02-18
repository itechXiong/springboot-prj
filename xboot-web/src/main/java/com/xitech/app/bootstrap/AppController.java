package com.xitech.app.bootstrap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
