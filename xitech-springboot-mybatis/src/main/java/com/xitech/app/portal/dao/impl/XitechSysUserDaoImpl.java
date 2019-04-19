package com.xitech.app.portal.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xitech.app.portal.dao.XitechSysUserDao;
import com.xitech.app.portal.entity.XitechSysUser;

@Repository
public class XitechSysUserDaoImpl implements XitechSysUserDao {

	@Autowired
	public SqlSession sqlSession;

	@Override
	public XitechSysUser findSysUserById() {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<>();
		params.put("id", "064dcbcf3aa24dff8931c4011816a035");
		String sqlPathPrefix = XitechSysUser.class.getName();
		String sqlId = "selectById";
		XitechSysUser sysUser = sqlSession.selectOne(sqlPathPrefix + "."+sqlId, params);
		return sysUser;
	}
}
