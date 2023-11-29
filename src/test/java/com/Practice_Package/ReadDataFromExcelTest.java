package com.Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\PRASANTH\\Desktop\\Projectdata2.xlsx");
		
		Workbook book= WorkbookFactory.create(fis);
		
		Sheet sh=book.createSheet("TestData1");
		Scanner sc=new Scanner(System.in);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\PRASANTH\\Desktop\\Projectdata2.xlsx");

		
		for(int i=0;i<5;i++)
		{
			sh.createRow(i);
			for(int j=0;j<2;j++)
			{
				System.out.println("Enter data into Cell");
				String data=sc.next();
				sh.getRow(i).createCell(j).setCellValue(data);
				
				
			}
		}
		book.write(fos);
		sc.close();
		
		/*
		 * Sheet sh = book.getSheet("Sheet1"); int lastrow=sh.getLastRowNum(); int
		 * lastcell=sh.getRow(0).getLastCellNum();
		 * 
		 * for(int i=0;i<=lastrow;i++) {
		 * 
		 * 
		 * for(int j=0;j<lastcell;j++) { String data =
		 * sh.getRow(i).getCell(j).getStringCellValue(); System.out.print(data+" "); }
		 * System.out.println(); }
		 */
		
		
		
	}

}
