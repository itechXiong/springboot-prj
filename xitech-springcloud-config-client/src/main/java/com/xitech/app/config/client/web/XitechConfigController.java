package com.xitech.app.config.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xitech.app.config.client.config.ConfigInfo;

@RestController
@RequestMapping("/config")
public class XitechConfigController {

	@Autowired
	private ConfigInfo configInfo;
	
	@RequestMapping("/getInfo")
	public String getConfigInfo() {
		return configInfo.getConfig();
	}
	
}
