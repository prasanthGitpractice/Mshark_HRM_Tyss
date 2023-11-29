package com.HRM.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public DataBaseutils dbutil=new DataBaseutils();
	public FileUtils futil=new FileUtils();
	public ExcelUtils eutil=new ExcelUtils();
	public WebDriverUtils wutil=new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable
	{
		dbutil.connectDB();
		System.out.println("----Connected to DB----");
	}
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	//public void config_BC(String BROWSER) throws Throwable
	public void config_BC() throws Throwable
	{
		String BROWSER = futil.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Firefox Browser Launched");
		}
		else
		{
			System.out.println("----Enter valid Browser Name----");
		}

		sdriver=driver;

		wutil.maximizeWindow(driver);

		String URL = futil.readDataFromPropertyFile("url");

		driver.get(URL);

	}

	@BeforeMethod(alwaysRun = true)
	public void config_BM()
	{
		//System.out.println("-------------"+result.getTestClass()+"-------------");
		//System.out.println("-------------"+result.getTestClass().getName()+"-------------");
		System.out.println("----Try Login to Application----");
	}

	@AfterMethod(alwaysRun = true)
	public void config_AM() throws Throwable
	{
		System.out.println("----Logged-Out of Application----");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		//driver.quit();
		System.out.println("----Browser Closed----");
	}
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws Throwable
	{
		dbutil.disConnectDB();
		System.out.println("----DB Disconnected----");
	}	

}
