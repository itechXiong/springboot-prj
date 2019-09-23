package com.xitech.app.feign;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xitech.app.feign.entity.FeignEntity;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableHystrix
//@EnableDiscoveryClient
@RestController
//@EnableHystrixDashboard//开启hystrix dashboard
//@RequestMapping("/hystrixFeignApi")
public class XitechSpringcloudFeignServerApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(XitechSpringcloudFeignServerApp.class, args);
    }
    
    @RequestMapping(value="/content/pojo")
	public String getContent(@RequestBody FeignEntity entity) {
    	
		//if("hystrix".equals(arg)) {
			return "remote正确结果:"+entity.getName();
		/*}else {
			throw new IllegalArgumentException("参数非法");
		}*/
		
	}
    
    @RequestMapping(value="/content/{arg}")
	public String getContent(@PathVariable("arg") String arg) {
    	
		if("hystrix".equals(arg)) {
			return "remote正确结果,普通字符串参数:"+arg;
		}else {
			throw new IllegalArgumentException("参数非法");
		}
		
	}
    
    @GetMapping("/content/header")
	public String getContent(HttpServletRequest request) {
    	return "gateway header: " + request.getHeader("testHeader");
	}
}
