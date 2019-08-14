package com.xitech.app.hystrix.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xitech.app.hystrix.service.fallback.HystrixFeignServiceFallback;

@FeignClient(name="hystrixFeignServer",fallback=HystrixFeignServiceFallback.class)
public interface HystrixFeignService {
	
	@RequestMapping(value="/hystrixFeignApi/content/{arg}",method=RequestMethod.GET)
	public String getContent(@PathVariable("arg") String arg);
	
	
	@RequestMapping(value="/getDashboard",method=RequestMethod.GET)
	public List<String> getDashboard();
	
	
	
}
