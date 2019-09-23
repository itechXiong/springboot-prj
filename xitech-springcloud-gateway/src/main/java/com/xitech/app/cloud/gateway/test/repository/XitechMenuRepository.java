package com.xitech.app.cloud.gateway.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xitech.app.cloud.gateway.test.entity.XitechMenu;

@Repository
public interface XitechMenuRepository extends CrudRepository<XitechMenu, Integer> {

}
