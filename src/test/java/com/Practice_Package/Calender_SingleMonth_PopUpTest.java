package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calender_SingleMonth_PopUpTest 
{

	public static void main(String[] args) 
	{
	
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//driver.findElement(By.id("fromPlaceName")).sendKeys("Hyderabad");
		//driver.findElement(By.xpath("//a[text()='HYDERABAD']")).click();
		
		//driver.findElement(By.id("toPlaceName")).sendKeys("bangalore");
		
		driver.findElement(By.id("txtJourneyDate")).click();
		
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='7']")).click();
		
		
		
		
	}

}
