package com.PageObjects;

import com.Utility.Constant;
import com.Utility.DataProviderClass;

public class Pageobjects {
	
	public static DataProviderClass obj;
	public static String url;
	public static String xpath;
	public static String image;
	
	public static void getTestData(int row, int col) {
		
		// Read test data for InvSch Tab of InvSch Page from excel file present in Data folder
		obj = new DataProviderClass(Constant.dataFile,Constant.dataSheet);
		
		url = obj.getCellData(row, col);
		xpath = obj.getCellData(row, col+1);
		image = obj.getCellData(row, col+2);
		

	} 
	

}
