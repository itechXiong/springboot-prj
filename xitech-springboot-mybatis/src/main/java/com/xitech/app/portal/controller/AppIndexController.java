package com.xitech.app.portal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xitech.app.framework.common.utils.KeyGeneratorUtils;
import com.xitech.app.portal.dao.XitechSysUserDao;
import com.xitech.app.portal.entity.XitechSysUser;
import com.xitech.app.portal.mapper.XitechSysUserMapper;

@RestController
public class AppIndexController {

	@Autowired
	private XitechSysUserDao xitechSysUserDao;
	
	@Autowired
	private XitechSysUserMapper xitechSysUserMapper;
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/clusterTest")
	public String clusterTest(){
		return port;
	}
	
	@RequestMapping("/findUser")
	public XitechSysUser findSysUser(@RequestParam String userId){
		return xitechSysUserDao.findSysUserById(userId);
	}
	
	@RequestMapping("/findUserByMapper")
	public XitechSysUser findSysUserByMapper(){
		return xitechSysUserMapper.findSysUserById("064dcbcf3aa24dff8931c4011816a035");
	}
	
	@RequestMapping("/insertUser")
	public String insertSysUser(){
		XitechSysUser sysUser = new XitechSysUser();
		sysUser.setId(KeyGeneratorUtils.generateId());
		sysUser.setCreateDate(new Date());
		sysUser.setCreater("admin1");
		sysUser.setUpdateDate(new Date());
		sysUser.setUpdater("admin1");
		sysUser.setUserDeptId("12312312");
		sysUser.setUserName("secondUser");
		sysUser.setUserPassword("secondUserPassword");
		return xitechSysUserDao.insertSysUser(sysUser);
		
	}
	
	
	@RequestMapping("/insertUserBatch")
	public String insertSysUserBatch(){
		List<XitechSysUser> list = new ArrayList<>();
		for(int i=0;i<1;i++) {
			XitechSysUser sysUser = new XitechSysUser();
			sysUser.setId(KeyGeneratorUtils.generateId());
			sysUser.setCreateDate(new Date());
			sysUser.setCreater("admin"+i);
			sysUser.setUpdateDate(new Date());
			sysUser.setUpdater("admin"+i);
			sysUser.setUserDeptId("12312312"+i);
			sysUser.setUserName("secondUser"+i);
			sysUser.setUserPassword("secondUserPassword");
			list.add(sysUser);
		}
		
		return xitechSysUserDao.insertSysUser(list);
		
		
	}
	
	@RequestMapping("/updateUser")
	public int updateUser(){
		
		return xitechSysUserDao.updateSysUser();
		
		
	}
}
