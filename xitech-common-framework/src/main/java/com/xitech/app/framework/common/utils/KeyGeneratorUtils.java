package com.xitech.app.framework.common.utils;

import java.util.UUID;

public class KeyGeneratorUtils {
	
	public static String generateId() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}

}
