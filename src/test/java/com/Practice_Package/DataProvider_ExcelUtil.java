package com.Practice_Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.ExcelUtils;

public class DataProvider_ExcelUtil 
{
	@Test(dataProvider ="dataProvider5")
	public void m5(String fName, String lName)
	{
		System.out.println(fName+" "+lName);
	}
	
	
	@DataProvider
	public Object[][] dataProvider4() throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\PRASANTH\\Desktop\\DataProviderdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		//int lastRow = sh.getLastRowNum();//Index 4 out of bounds for length 4
		int lastRow = sh.getPhysicalNumberOfRows();
		System.out.println(lastRow);
		int lastCell = sh.getRow(0).getLastCellNum();
		System.out.println(lastCell);
		Object[][] obj = new Object[lastRow][lastCell];
		
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}
	
	@DataProvider
	public Object[][] dataProvider5() throws Throwable
	{
		ExcelUtils eUtil=new ExcelUtils();
		Object[][] obj = eUtil.readDataByDataProvider("Sheet1");
		return obj;
				
	}
}
