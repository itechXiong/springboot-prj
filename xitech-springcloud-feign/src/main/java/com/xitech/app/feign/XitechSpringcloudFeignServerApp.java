package com.xitech.app.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableHystrix
@EnableDiscoveryClient
//@RestController
@EnableHystrixDashboard//开启hystrix dashboard
//@RequestMapping("/hystrixFeignApi")
public class XitechSpringcloudFeignServerApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(XitechSpringcloudFeignServerApp.class, args);
    }
    
    /*@RequestMapping("/content/{arg}")
	public String getContent(@PathVariable String arg) {
		if("hystrix".equals(arg)) {
			return "remote正确结果!";
		}else {
			throw new IllegalArgumentException("参数非法");
		}
		
	}*/
}
