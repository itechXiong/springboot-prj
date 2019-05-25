package com.xitech.app.portal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xitech.app.framework.common.dao.GenericBaseDao;
import com.xitech.app.portal.dao.XitechSysUserDao;
import com.xitech.app.portal.entity.XitechSysUser;
import com.xitech.app.zklock.XitechZookeeperClient;
import com.xitech.app.zklock.XitechZookeeperLock;

/*@Transactional(readOnly=true)*/
@Repository
public class XitechSysUserDaoImpl extends GenericBaseDao<XitechSysUser> implements XitechSysUserDao {

	@Autowired
	private XitechZookeeperClient client;
	//CuratorFramework client;
	
	@Autowired
	private XitechZookeeperLock lock;
	//InterProcessMutex lock;
	
	@Override
	public XitechSysUser findSysUserById(String userId) {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<>();
		params.put("id", userId);
		String sqlPathPrefix = XitechSysUser.class.getName();
		String queryListSqlId="selectId";
		String sqlId = "selectById";
		String updateSqlId = "updateById";
		this.getSqlSession().update(sqlPathPrefix + "."+updateSqlId,params);
		List<String> ids = this.getSqlSession().selectList(sqlPathPrefix + "."+queryListSqlId);
		long start =System.currentTimeMillis();
		for(String id :ids) {
			params.put("id", id);
			this.getSqlSession().selectOne(sqlPathPrefix + "."+sqlId, params);
		}
		XitechSysUser sysUser = null;
		long end =System.currentTimeMillis();
		System.out.println("**********************耗时("+(end-start)+"************************");
		
		return sysUser;
	}
	
	

	/*@Transactional(readOnly=false,
			rollbackFor= {Exception.class},
			propagation=Propagation.REQUIRED)*/
	@Override
	public String insertSysUser(XitechSysUser sysUser) {
		// TODO Auto-generated method stub
		String userId = null;
		try {
			//lock.lockWrite();
			//System.out.println("**********************ExecutorType:"+this.getSqlSession().getConfiguration().getDefaultExecutorType());
			String sqlPathPrefix = XitechSysUser.class.getName();
			String sqlId = "insertSelective";
			int isSuccess = this.getSqlSession().insert(sqlPathPrefix+ "."+sqlId, sysUser);
			userId =  sysUser.getId();
			if(userId != null) {
				//throw new IllegalArgumentException("sdfa");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//lock.releaseWrite();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return userId;
	}

	@Override
	public String insertSysUser(List<XitechSysUser> sysUserList) {
		// TODO Auto-generated method stub
		System.out.println("**********************ExecutorType:"+this.getSqlSession().getConfiguration().getDefaultExecutorType());
		long start =System.currentTimeMillis();
		String sqlPathPrefix = XitechSysUser.class.getName();
		String sqlId = "insertSelective";
		Map<String,Object> params = new HashMap<>();
		params.put("list", sysUserList);
		int isSuccess = this.getSqlSession().insert(sqlPathPrefix+ "."+sqlId, params);
		long end =System.currentTimeMillis();
		System.out.println("**********************耗时("+(end-start)+"************************");
		return "success";
	}



	@Override
	public int updateSysUser() {
		// TODO Auto-generated method stub
		
		String sqlPathPrefix = XitechSysUser.class.getName();
		String sysUserIndexId = "96c287ed15f04a819adbfdeaea15a727";
		System.out.println("*************"+Thread.currentThread().getName()+"*************8088:begin");
		//获取旧数据
		Map<String,Object> params = new HashMap<>();
		params.put("id", sysUserIndexId);
		String sqlId = "selectById";
		
		try {
			System.out.println("************"+Thread.currentThread().getName()+"等待获取锁8089******"+lock);
			lock.lock();//lockWrite();
			System.out.println("----------" +Thread.currentThread().getName()+"获得资源8089----------");
			XitechSysUser dbUser = this.getSqlSession().selectOne(sqlPathPrefix + "."+sqlId, params);
			Integer deptId = Integer.valueOf(dbUser.getUserDeptId());
			deptId = deptId +1;
		Thread.sleep(5000);
		dbUser.setUserDeptId(String.valueOf(deptId));
		
		String updateSqlId = "updateById";
		this.getSqlSession().update(sqlPathPrefix + "."+updateSqlId,dbUser);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				lock.release();//releaseWrite();
				System.out.println("----------" +Thread.currentThread().getName()+"释放锁8089----------");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long start =System.currentTimeMillis();
		System.out.println("*************"+Thread.currentThread().getName()+"*************8088:end");
		return 0;
	}
	
	@PostConstruct
	public void start() {
		System.out.println("*****************init zookeeper*******************");
		//RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		//client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
		client.start();
		
		//this.lock = new InterProcessMutex(client,"/springboot");//new XitechZookeeperLock(client);
	}
	
	@PreDestroy
	public void close() {
		System.out.println("*****************close zookeeper*******************");
		client.close();
	}
}
