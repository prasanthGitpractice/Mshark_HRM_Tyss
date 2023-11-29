package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Calender_MakeMyTrip 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(5000);
		
		Actions act=new Actions(driver);
		act.click().perform();
		act.click().perform();
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='wewidgeticon we_close']"))).click();
//		//driver.findElement(By.className("close")).click();
		
		driver.findElement(By.className("commonModal__close")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		driver.findElement(By.xpath("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='8']")).click();
		
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[@class='DayPicker-Month'][2]/descendant::p[text()='13']")).click();
				break;
			}
			catch (Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
	}

}
