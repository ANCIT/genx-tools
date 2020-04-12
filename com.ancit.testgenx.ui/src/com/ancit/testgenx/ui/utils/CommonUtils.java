package com.ancit.testgenx.ui.utils;

import java.io.File;

public class CommonUtils {
	public static String generateTempFolder() {
		File file = new File(System.getProperty("user.home") + File.separator +"TestGenx");
		if (!file.exists()) {
			file.mkdir();
		}
		return file.getAbsoluteFile().toString();
	}

}
