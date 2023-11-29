package com.Practice_Package;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Dummy 
{
	@Test(dependsOnMethods = "d")
	public void a()
	{
		System.out.println("Method a()");
	}
	
	@Test()
	public void b()
	{
		System.out.println("Method b()");
	}

	@Test(dependsOnMethods = "b")
	public void c()
	{
		System.out.println("Method c()");
	}

	@Test(dependsOnMethods = "b")
	public void d()
	{
		System.out.println("Method d()");
	}
	
	@Test
	public void e()
	{
		System.out.println("Method e()");
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("HRM_52");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Mshark_Amcor Plc");
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("Url", "http://");
		report.setSystemInfo("reporter_name", "Prasanth");
	}

	
	
}
