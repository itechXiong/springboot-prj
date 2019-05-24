package com.xitech.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xitech.app.web.feign.XitechAppFeignClient;

@RestController
@RequestMapping("/web")
public class XitechAppWebController {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private XitechAppFeignClient feignClient;
	
	
	@RequestMapping("/findUser")
	public String findUser() {
		//restTemplate.getForEntity("http://localhost:8888", responseType)
		return restTemplate.getForEntity("http://XITECH-SYS-USER-SERVICE/findUser", String.class).getBody();
	}
	
	@RequestMapping("/findUserById")
	public String findUserById(@RequestParam("userId")String userId) {
		return feignClient.findUser(userId);
	}
	
	@RequestMapping("/insertUser")
	public String inserUser() {
		return feignClient.insertUser();
	}
}
