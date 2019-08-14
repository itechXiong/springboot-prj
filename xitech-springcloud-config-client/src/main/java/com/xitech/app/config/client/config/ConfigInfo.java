package com.xitech.app.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
//@ConfigurationProperties(prefix="cn.info")
public class ConfigInfo {

	@Value("${cn.info.config}")
	private String config;

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}


	
	
}
