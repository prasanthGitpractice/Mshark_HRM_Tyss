package com.Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Data provider and Test method in same class
public class DataProvider1 
{
	
	
	@Test(dataProvider = "dataProvider1" )
	public void m1(String fName, String lName)
	{
		System.out.println(fName+" "+lName);
	}
	
	
	@DataProvider
	public Object[][] dataProvider1()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="Hency";
		obj[0][1]="Priya";

		obj[1][0]="Prakash";
		obj[1][1]="kumar";

		obj[2][0]="Pavi";
		obj[2][1]="Potti";

		return obj;
	}
	
}
