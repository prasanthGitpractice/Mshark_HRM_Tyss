package com.Practice_Package;

import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;


public class Demo2 extends BaseClass
{
	@Test
	public void m3()
	{
		System.out.println("method m3");
	}
	
	@Test(groups = "smoke")
	public void m4()
	{
		System.out.println("method m4");
	}
}
