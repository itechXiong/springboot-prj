package com.xitech.app.portal.dao;

import java.util.List;

import com.xitech.app.framework.base.dao.BaseDao;
import com.xitech.app.portal.entity.XitechSysUser;

public interface XitechSysUserDao extends BaseDao<XitechSysUser>{
	
	public XitechSysUser findSysUserById(String userId);
	
	public String insertSysUser(XitechSysUser sysUser);
   
	public String insertSysUser(List<XitechSysUser> sysUserList);
	
	public int updateSysUser();
}