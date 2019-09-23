package com.xitech.app.test.spi.impl;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

import com.xitech.app.test.spi.interf.XitechSpiPrint;

public class XitechSpiPrintWrapper implements XitechSpiPrint {

	
	private final XitechSpiPrint printImpl;

	public XitechSpiPrintWrapper(XitechSpiPrint printImpl) {
		this.printImpl = printImpl;
	}

	@Override
	public void print(URL url, String msg, boolean withKey) {
		// TODO Auto-generated method stub
		System.out.println("*****************wrapper impl");
		this.printImpl.print(url, msg, withKey);
	}

}
