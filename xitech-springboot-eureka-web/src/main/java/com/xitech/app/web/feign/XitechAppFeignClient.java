package com.xitech.app.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="XITECH-SYS-USER-SERVICE")
public interface XitechAppFeignClient {
	
	
	@RequestMapping(value="/insertUser")
	public String insertUser();

	
	@RequestMapping(value="/findUser")
	public String findUser(@RequestParam String userId);
}
