package com.xitech.app.hystrix.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xitech.app.hystrix.service.HystrixFeignService;

@RestController
@RequestMapping("/hystrixApp")
public class SpringCloudHystrixController {
	
	@RequestMapping("/content/{arg}")
	@HystrixCommand(fallbackMethod="fallbackContent",commandKey="getCon")
	public String getContent(@PathVariable String arg) {
		System.out.println("方法逻辑");
		if("hystrix".equals(arg)) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "正确结果!";
		}else {
			throw new IllegalArgumentException("参数非法");
		}
		
	}
	/**
	 * 该方法是@HystrixCommand注解中fallbackMethod属性值指定的方法，是该注解修饰的方法的降级方法
	 * 方法的参数 “必须”与原方法保持一致。
	 * @param arg
	 * @return
	 */
	private String fallbackContent(@PathVariable String arg) {
		return "容错结果"+arg;
	}
	
	
	
	@Autowired
	private HystrixFeignService hystrixFeignService;
	
	/**
	 * feign中使用降级容错（hystrix）
	 * @param arg
	 * @return
	 */
	@RequestMapping("/content/feign/{arg}")
	public String getFeignContent(@PathVariable String arg) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hystrixFeignService.getContent(arg);
	}
	
	@RequestMapping("/dashboard")
	public List<String> getDashboard() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hystrixFeignService.getDashboard();
	}

}
