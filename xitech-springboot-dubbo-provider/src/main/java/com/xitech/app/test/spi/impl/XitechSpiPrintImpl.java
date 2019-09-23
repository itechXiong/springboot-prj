package com.xitech.app.test.spi.impl;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

import com.xitech.app.test.spi.interf.XitechSpiPrint;

public class XitechSpiPrintImpl implements XitechSpiPrint {

	@Override
	public void print(URL url, String msg, boolean withKey) {
		// TODO Auto-generated method stub
		System.out.println("*****************impl");
	}

}
