package com.xitech.app.main;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import com.xitech.app.test.spi.impl.XitechSpiPrintImpl;
import com.xitech.app.test.spi.interf.XitechSpiPrint;

public class XitechAppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtensionLoader<XitechSpiPrint> eloader = ExtensionLoader.getExtensionLoader(XitechSpiPrint.class);
		URL url = URL.valueOf("test://localhost/tet");
		XitechSpiPrint print = eloader.getDefaultExtension();//getExtension("dubbo1");
		
		print.print(url, "msg", true);
	}

}
