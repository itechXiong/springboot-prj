package com.xitech.app.rocketmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xitech.app.rocketmq.producer.XitechRocketMqProducer;

@RestController
public class XitechRocketMqController {
	
	@Autowired
	private XitechRocketMqProducer xitechRocketMqProducer;
	
	@RequestMapping("/testMQ")
	public String testMq() {
		xitechRocketMqProducer.defaultMQProducer();
		return null;
	}
}
