package com.HRM.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtils 
{
	/**
	 * This method is used to read data from Excel
	 * @author PRASANTH
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetname, int row, int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		String value = sheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to get lastrow number from an excel sheet
	 * @author PRASANTH
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getLatRowNo(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		int count = sheet.getLastRowNum();
		return count;
	}
	
	/**
	 * This method is used to write data into Excel
	 * @author PRASANTH
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void writedataIntoExcel(String sheetname, int row, int cell, String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		sheet.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fos);
		book.close();
	}
	
	
	/**
	 * This method is used to read Multiple data from Excel
	 * @author PRASANTH
	 * @param sheetName
	 * @param driver
	 * @throws Throwable 
	 */
	public void readMultipleDataFromExcel(String sheetName, WebDriver driver, int lastRow, int keyCellNO) throws Throwable
	{	
		JavaUtils jlib = new JavaUtils();
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		//int count = sheet.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=2; i<=lastRow; i++)
		{
			String key = sheet.getRow(i).getCell(keyCellNO).getStringCellValue();
			String value = sheet.getRow(i).getCell(keyCellNO+1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> set : map.entrySet())
		{
			if(set.getKey().contains(""))
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());//+jlib.getRandomNO());
				System.out.println(set.getKey()+"   "+set.getValue());
			}
			else
			{
				
			}
		}
	}
	
	
	public Object[][] readDataByDataProvider(String sheetname) throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\PRASANTH\\Desktop\\DataProviderdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
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
	
	
	
}
