package com.xitech.app.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xitech.app.portal.dao.XitechSysUserDao;
import com.xitech.app.portal.entity.XitechSysUser;

@RestController
public class AppIndexController {

	@Autowired
	private XitechSysUserDao xitechSysUserDao;
	
	@RequestMapping("/findUser")
	public XitechSysUser findSysUser(){
		return xitechSysUserDao.findSysUserById();
	}
}
