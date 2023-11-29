package com.Practice_Package;

import org.testng.annotations.Test;


// Dataprovider of Other class
public class TestDataProviderClass2 
{
	@Test(dataProviderClass = DataProviderClass2.class,  dataProvider = "dataProvider2" )
	public void m1(String fName, String lName)
	{
		System.out.println(fName+" "+lName);
	}
	
}
