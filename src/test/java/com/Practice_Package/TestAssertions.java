package com.Practice_Package;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.FileUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//import org.testng.asserts.SoftAssert;
//import static org.testng.asserts.SoftAssert.*;

import static org.testng.Assert.*; //-----------import all req classes no need to use "Assert." all  

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAssertions extends BaseClass
{
	
	//@Test
	public void m1()
	{
		String expData="Prasanth";
		String actData="prasanth";
		System.out.println("-- TC1 --");
		System.out.println("-- TC1 --");
		System.out.println("-- TC1 --");
		assertEquals(actData, expData);
		System.out.println("-- TC1 --");
		System.out.println("-- TC1 --");
		System.out.println("-- TC1 --");
	}
	
	@Test
	public void m2() throws Throwable
	{
		FileUtils futil = new FileUtils();
		String USERNAME = futil.readDataFromPropertyFile("userEmail");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL = futil.readDataFromPropertyFile("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginAsHrHead(USERNAME, PASSWORD, lp.getDdEle_hrHead());
		WebDriverUtils wutil=new WebDriverUtils();
		wutil.acceptAlert(driver);
		String expTitle="Admin | ";
		String actTitle = driver.getTitle();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actTitle, expTitle,"Expected is not found");
		//sa.assertAll();
		System.out.println(actTitle);
	}
}
