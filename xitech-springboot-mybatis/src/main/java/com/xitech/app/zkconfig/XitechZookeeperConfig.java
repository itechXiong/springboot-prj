package com.xitech.app.zkconfig;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.xitech.app.zklock.XitechZookeeperClient;
import com.xitech.app.zklock.XitechZookeeperLock;

@Configuration
@PropertySource(value={"classpath:/application.properties"})
@Component
public class XitechZookeeperConfig {
	
	private static final int SLEEP_TIME_MS = 1000;
    private static final int MAX_RETRIES = 3;

    @Autowired
    private Environment environment;
    
    /**
     * 创建重试策略对象
     * @return
     */
    
	@Bean
	public RetryPolicy retryPolicy() {
		String sleepTimeMsStr = environment.getProperty("sleepTime");
		String maxRetriesStr = environment.getProperty("maxRetries");
		int sleepTime = SLEEP_TIME_MS;
		int maxRetries = MAX_RETRIES;
		if(StringUtils.isNotBlank(sleepTimeMsStr) && StringUtils.isNumeric(sleepTimeMsStr)) {
			sleepTime = Integer.valueOf(sleepTimeMsStr);
		}
		if(StringUtils.isNotBlank(maxRetriesStr) && StringUtils.isNumeric(maxRetriesStr)) {
			maxRetries = Integer.valueOf(sleepTimeMsStr);
		}
		return new ExponentialBackoffRetry(sleepTime, maxRetries);
	}
	
    
	@Bean
	public XitechZookeeperClient xitechZookeeperClient() {
		
		return new XitechZookeeperClient(retryPolicy());
	}
	
    
	@Bean
	public XitechZookeeperLock xitechZookeeperLock() {
		
		return new XitechZookeeperLock(xitechZookeeperClient().getClient());
	}
	
	
}
