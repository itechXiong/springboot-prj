package com.xitech.app.framework.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.xitech.app.framework.base.dao.AbstractGenericBaseDao;
import com.xitech.app.framework.common.entity.BaseEntity;

public abstract class GenericBaseDao<T extends BaseEntity> extends AbstractGenericBaseDao<T> {

	@Autowired
	private SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return this.sqlSession;
	}
}
