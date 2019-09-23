package com.xitech.app.bootstrap;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
//@ImportResource(value= {"classpath*:xboot-web-spring-redis.xml"})
@PropertySource(value={"classpath:/application.properties"})
public class AppConfig {
	 //@Autowired ClusterConfigurationProperties clusterProperties;

	@Autowired
	Environment env;
   /* public @Bean RedisConnectionFactory lettuceConnFactory() {
    	List<String> nodes = Arrays.asList(env.getProperty("spring.redis.cluster.nodes").split(","));
        return new LettuceConnectionFactory(
            new RedisClusterConfiguration(nodes));
    }*/
	
	/*@Value("${spring.redis.cluster.nodes}")
	List<String> nodes;*/
	
	
	
	/*@Bean
	public RedisConnectionFactory lettuceRedisFactory() {
		//nodes = Arrays.asList(environment.getProperty("spring.redis.cluster.nodes").split(","));
		for(String node : nodes) {
			System.out.println("**************:"+node);
		}
        return new LettuceConnectionFactory(new RedisClusterConfiguration(nodes));
	}
	
	
	@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate template = new RedisTemplate();
		template.setConnectionFactory(lettuceRedisFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}*/
    /*@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate template = new RedisTemplate();
		template.setConnectionFactory(lettuceRedisFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}*/
	
	
}
