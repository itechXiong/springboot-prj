package com.xitech.app.test.spi.interf;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

//@SPI("dubbo")  // 包装扩展点
@SPI("impl") //普通扩展点实现
public interface XitechSpiPrint {
	
	//@Adaptive("printl")// 包装扩展点
	public void print(URL url , String msg,boolean withKey);
}
