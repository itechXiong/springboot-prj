package com.xitech.app.framework.common.service;

import com.xitech.app.framework.base.dao.BaseDao;
import com.xitech.app.framework.base.service.AbstractGenericBaseService;
import com.xitech.app.framework.common.entity.BaseEntity;

public class GenericBaseService<D extends BaseDao<BaseEntity>,E extends BaseEntity> extends AbstractGenericBaseService<D,E> {

}
