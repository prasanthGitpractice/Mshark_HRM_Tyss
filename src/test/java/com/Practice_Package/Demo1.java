package com.Practice_Package;

import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;

public class Demo1 extends BaseClass
{
	@Test(groups = "smoke")
	public void m1()
	{
		System.out.println("method m1");
	}
	
	@Test
	public void m2()
	{
		System.out.println("method m2");
	}
}
