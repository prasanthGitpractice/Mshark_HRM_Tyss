package com.Practice_Package;

import org.testng.annotations.Test;

public class TestDataProviderClass3 
{
	@Test(dataProviderClass = DataProviderClass3.class,  dataProvider = "dataProvider3_1" )
	public void m1(String fName, String lName)
	{
		System.out.println(fName+" "+lName);
	}
	
	
	@Test
	public void m2()
	{
		System.out.println();
	}
	
	 
}
