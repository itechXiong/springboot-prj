package com.xitech.app.zklock;

import javax.annotation.PostConstruct;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class XitechZookeeperLock {

	private InterProcessReadWriteLock lock;
	
	private InterProcessMutex readLock;
	
	private InterProcessMutex writeLock;
	
	private InterProcessMutex sLock;
	
	private CuratorFramework client;
	
	@Value("${zookeeper.lockPath}")
	private String lockPath;
	
	public XitechZookeeperLock(CuratorFramework client) {
		this.client = client;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("**************init Lock**************");
		System.out.println("*****************lockpath***"+this.lockPath);
		this.sLock = new InterProcessMutex(this.client,this.lockPath);
		this.lock = new InterProcessReadWriteLock(this.client,this.lockPath);
		this.writeLock = lock.writeLock();
		this.readLock = lock.readLock();
	}
	
	public void lockWrite() throws Exception {
		this.writeLock.acquire();
	}
	
	public void lockRead() throws Exception{
		this.readLock.acquire();
	}
	
	
	public void releaseWrite() throws Exception {
		this.writeLock.release();
	}
	
	public void releaseRead() throws Exception{
		this.readLock.release();
	}
	
	public void lock() throws Exception{
		this.sLock.acquire();
	}
	
	public void release() throws Exception{
		this.sLock.release();
	}
}
