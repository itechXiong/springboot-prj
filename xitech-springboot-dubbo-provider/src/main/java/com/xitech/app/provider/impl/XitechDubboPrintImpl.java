package com.xitech.app.provider.impl;

import org.apache.dubbo.config.annotation.Service;
import com.xitech.app.interfaced.XitechDubboPrint;

@Service(version = "1.0.0")
public class XitechDubboPrintImpl implements XitechDubboPrint {

	@Override
	public void printMethod(String content) {
		// TODO Auto-generated method stub
		System.out.println("********** dubbo provider print : "+content);
	}

}
