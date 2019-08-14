package com.xitech.app.bootstrap;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

	@Autowired
	Environment env;

	List<String> nodes;
	
	
	/*@Bean
	public LettuceConnectionFactory lettuceConnFactory() {
		nodes = Arrays.asList(env.getProperty("spring.redis.cluster.nodes").split(","));
		for(String node: nodes) {
			System.out.println("**********"+node);
		}
		return new LettuceConnectionFactory(new RedisClusterConfiguration(nodes));
	}
	
	@Bean
	public RedisTemplate lettuceConnFactory() {
		nodes = Arrays.asList(env.getProperty("spring.redis.cluster.nodes").split(","));
		for(String node: nodes) {
			System.out.println("**********"+node);
		}
		return new LettuceConnectionFactory(new RedisClusterConfiguration(nodes));
	}*/
}
