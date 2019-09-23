package com.xitech.app.cloud.gateway.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xitech.app.cloud.gateway.test.entity.XitechMenu;
import com.xitech.app.cloud.gateway.test.repository.XitechMenuRepository;

@Service
public class XitechMenuService {
	@Autowired
	private XitechMenuRepository xitechMenuRepository;
	
	
	public XitechMenu findMenuById(Integer id) {
		return xitechMenuRepository.findById(id).get();
	}
	
	
	public void insertMenu(XitechMenu menu) {
		xitechMenuRepository.save(menu);
	}
}
