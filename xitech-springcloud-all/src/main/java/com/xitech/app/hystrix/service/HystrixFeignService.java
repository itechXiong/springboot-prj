package com.xitech.app.hystrix.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xitech.app.hystrix.entity.FeignEntity;
import com.xitech.app.hystrix.service.fallback.HystrixFeignServiceFallback;
//
@FeignClient(name="hystrixFeignServer",fallback=HystrixFeignServiceFallback.class,path="/hystrixFeignApi")
public interface HystrixFeignService {
	
	@RequestMapping(value="/content/pojo")//
	public String getContent(@RequestBody FeignEntity entity);
	
	@RequestMapping(value="/content/{arg}")//
	public String getContent(@PathVariable("arg") String arg);
	
	
	@RequestMapping(value="/getDashboard",method=RequestMethod.GET)
	public List<String> getDashboard();
	
	
	
}
