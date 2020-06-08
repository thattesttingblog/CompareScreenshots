package com.Utilities;

import com.Utilities.Constant;

public class BaseClass{
	
	public static void initiateChromeDriver() {
		
		System.setProperty(Constant.chromeWebDriverName, Constant.chromeWebDriverPath);
	
		
	}
}
