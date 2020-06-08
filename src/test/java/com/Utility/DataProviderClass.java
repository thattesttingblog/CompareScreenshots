package com.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class DataProviderClass {
	public  FileInputStream myExcelFile = null;
	public HSSFWorkbook workbook = null;
	public HSSFSheet worksheet = null;
	public HSSFRow row;
	public HSSFCell cell;
	public String values[][] = null;
	
	public DataProviderClass(String strFileName, String strSheetName)
	{
		//System.out.println(strSheetName);
		try 
		{
			myExcelFile = new FileInputStream(strFileName);
			workbook = new HSSFWorkbook(myExcelFile);
			worksheet = workbook.getSheet(strSheetName);
			row = worksheet.getRow(0);
			cell = row.getCell(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String [][] retreiveData()
	{
		try
		{
			int rowCount = worksheet.getLastRowNum();
			int colCount = worksheet.getRow(0).getLastCellNum();
			//System.out.println("rows "+rowCount);
			//System.out.println("Columns "+colCount);
			
			values = new String[rowCount][colCount];
			
			for(int i = 0; i < rowCount ; i++)
			{
				for(int j = 0; j < colCount ; j++)
				{
					row = worksheet.getRow(i+1);
					cell =  row.getCell(j);
					//System.out.println(cell);
					if(cell!=null)
					values[i][j] = new DataFormatter().formatCellValue(cell);
					else
					values[i][j] = "";	
				}
			}
//			return values;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return values;
	}
	
	public String getCellData(int rowNum, int colNum)
	{
		String s = null;
		try
		{
			row = worksheet.getRow(rowNum);
			cell =  row.getCell(colNum);
			//System.out.println(cell);
			if(cell!=null)
			s = new DataFormatter().formatCellValue(cell);
			else
			s = "";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	public void closeFile()
	{
		try {
			myExcelFile.close();
			} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
