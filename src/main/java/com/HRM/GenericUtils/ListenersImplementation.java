package com.HRM.GenericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test ;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		//logging report on test start
		String methodname =  result.getMethod().getMethodName();
		test = report.createTest(methodname);//invoking method name into report
		Reporter.log(methodname+"--- TestScript Execution Starts From Here ---");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//logging report on test Success
		String methodname =  result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"----> PASSED");
		Reporter.log(methodname+" Executed Succeessfully");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//logging report on test Failure
		String method = result.getMethod().getMethodName();
		String methodName = method + new JavaUtils().systemDateInFormat();
		test.addScreenCaptureFromPath(methodName); // its is going to add screenshot name of failed testscript, but it will not add any screenshot in extent report.
		// Based on this screenshot name present in report, we can search that screenshot in screenshots folder inorder to debug issue.
		try {
			WebDriverUtils.getScreenshot(BaseClass.sdriver, methodName);
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}	
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, methodName+" -----> FAILED");
		Reporter.log(methodName+" TestScript Execution Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		//Logging report on test skip
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" --> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"---Test Script Execution Skipped");		
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		//cofigure report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("sdet52");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("HRM_TYSS");
		
		//system info
		report = new ExtentReports();
		report.attachReporter(htmlReport);//attaching html report--must be 
		report.setSystemInfo("BaseBrowser", "Chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/HRM_System/");
		report.setSystemInfo("Reporter Name", "Prasanth");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		// Consolidate the report/ clean older Report
		report.flush();
	}
	
}
