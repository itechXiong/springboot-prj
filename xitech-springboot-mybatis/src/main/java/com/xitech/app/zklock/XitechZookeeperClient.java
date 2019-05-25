package com.xitech.app.zklock;

import javax.annotation.PostConstruct;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class XitechZookeeperClient {
	
	private CuratorFramework client;
	
	private RetryPolicy retryPolicy;
	
	/**
	 * {@value}注解的注入操作时在构造函数之后，因此，在构造函数中使用zkServerString时还未注入值，故抛出连接字符串的异常null的异常
	 */
	@Value("${zookeeper.server}")
	private String zkSererString;
	
	public XitechZookeeperClient() {
		super();
	}
	
	public XitechZookeeperClient(RetryPolicy retryPolicy) {
		this.retryPolicy = retryPolicy;
		//this.zkSererString = 
	}
	
	@PostConstruct
	public void init() {
		System.out.println("***************init zk client:serverString:"+this.zkSererString);
		this.client = CuratorFrameworkFactory.newClient(this.zkSererString, retryPolicy);
	}
	
	/**
	 * 开启客户端
	 */
	public void start() {
		this.client.start();
	}
	
	/**
	 * 开启客户端
	 */
	public void close() {
		this.client.close();
	}
	
	public CuratorFramework getClient() {
		return this.client;
	}


}
