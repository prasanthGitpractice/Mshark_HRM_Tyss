package com.Practice_Package;

import org.testng.annotations.DataProvider;

public class DataProviderClass3 
{
	@DataProvider
	public Object[][] dataProvider3_1()
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
	
	@DataProvider
	public Object[][] dataProvider3_2()
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
