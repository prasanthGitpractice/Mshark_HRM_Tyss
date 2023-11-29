package com.Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertAndReadDataFromPropertyFileTest 
{

	public static void main(String[] args) throws IOException 
	{
		
		Properties pobj=new Properties();
		
		pobj.setProperty("Browser", "Chrome");
		pobj.setProperty("url", "http://rmgtestingserver/domain/HRM_System/");
		pobj.setProperty("userName", "hrhead@gmail.com");
		pobj.setProperty("password", "hrhead@123");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		
		pobj.store(fos, "write data");
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("userName");
		String PASSWORD = pobj.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement type_dd = driver.findElement(By.id("hr_type"));
		Select s=new Select(type_dd);
		
		s.selectByValue("HR Head");
		
		driver.findElement(By.name("login_hr")).click();
		
		
		
	}

}
