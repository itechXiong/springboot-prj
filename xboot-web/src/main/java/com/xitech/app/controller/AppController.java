package com.xitech.app.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	
	@Resource(name="redisTemplate")
    private ValueOperations<String, Boolean> valueRedis;
	
	@Autowired
    private RedisTemplate redisTemplate;

/*	@PostConstruct
    public void init(){
		valueRedis=valueRedis.opsForValue();
    }
	
*/	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@Scheduled(cron = "0/10 * * * * *")
	public void print() {

		System.out.println("当前时间：" + System.currentTimeMillis());
	}
	
	
	@RequestMapping("/cache")
	@Cacheable("test")
	public String getCache(){
		boolean isCache = true;
		//lettuceRedisFactory.getConnection();
		Boolean result = valueRedis.get("testR");
		if(result == null) {
			System.out.println("执行了方法");
			isCache = false;
			valueRedis.set("testR", isCache,15l,TimeUnit.SECONDS);
		}
		return "执行结果: "+ isCache;
	}
	
}
