package com.xitech.app.hystrix.service.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xitech.app.hystrix.service.HystrixFeignService;

@Component
public class HystrixFeignServiceFallback implements HystrixFeignService {

	@Override
	public String getContent(String arg) {
		// TODO Auto-generated method stub
		return "feign方式降级容错:"+arg;
	}

	@Override
	public List<String> getDashboard() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("feign方式降级容错:getDashboard");
		return list;
	}

}
