package com.xitech.app.portal.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xitech.app.framework.common.dao.GenericBaseDao;
import com.xitech.app.portal.dao.XitechSysUserDao;
import com.xitech.app.portal.entity.XitechSysUser;

/*@Transactional(readOnly=true)*/
@Repository
public class XitechSysUserDaoImpl extends GenericBaseDao<XitechSysUser> implements XitechSysUserDao {

	@Override
	public XitechSysUser findSysUserById(String userId) {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<>();
		params.put("id", userId);
		String sqlPathPrefix = XitechSysUser.class.getName();
		String sqlId = "selectById";
		XitechSysUser sysUser = this.getSqlSession().selectOne(sqlPathPrefix + "."+sqlId, params);
		return sysUser;
	}

	/*@Transactional(readOnly=false,
			rollbackFor= {Exception.class},
			propagation=Propagation.REQUIRED)*/
	@Override
	public String insertSysUser(XitechSysUser sysUser) {
		// TODO Auto-generated method stub
		
		String sqlPathPrefix = XitechSysUser.class.getName();
		String sqlId = "insertSelective";
		int isSuccess = this.getSqlSession().insert(sqlPathPrefix+ "."+sqlId, sysUser);
		String userId =  sysUser.getId();
		if(userId != null) {
			//throw new IllegalArgumentException("sdfa");
		}
		
		return userId;
	}
}
