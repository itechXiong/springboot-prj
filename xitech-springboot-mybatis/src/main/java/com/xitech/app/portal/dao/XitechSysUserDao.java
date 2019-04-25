package com.xitech.app.portal.dao;

import com.xitech.app.framework.base.dao.BaseDao;
import com.xitech.app.portal.entity.XitechSysUser;

public interface XitechSysUserDao extends BaseDao<XitechSysUser>{
	
	public XitechSysUser findSysUserById();
	
	public String insertSysUser(XitechSysUser sysUser);
   
}