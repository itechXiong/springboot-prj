package com.xitech.app.hystrix.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xitech.app.hystrix.service.HystrixFeignService;

@RestController
@RequestMapping("/hystrixFeignApiLocal")
public class SpringCloudHystrixApiController {
	
	@RequestMapping("/content/{arg}")
	public String getContent(@PathVariable String arg) {
		if("hystrix".equals(arg)) {
			return "模拟remote正确结果!";
		}else {
			throw new IllegalArgumentException("参数非法");
		}
		
	}
}
