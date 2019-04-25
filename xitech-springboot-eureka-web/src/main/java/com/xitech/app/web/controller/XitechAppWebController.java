package com.xitech.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/web")
public class XitechAppWebController {

	@Autowired
    private RestTemplate restTemplate;
	@RequestMapping("/findUser")
	public String findUser() {
		//restTemplate.getForEntity("http://localhost:8888", responseType)
		return restTemplate.getForEntity("http://XITECH-SYS-USER-SERVICE/findUser", String.class).getBody();
	}
}
