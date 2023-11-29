package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task6 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		
		driver.findElement(By.xpath("//div[.='From']")).click();
		
		driver.findElement(By.xpath("//div[.='From']")).sendKeys("Ben");

		Thread.sleep(5000);

		//Destination is not selecting
		driver.findElement(By.xpath("//div[.='To']")).click();
		
		driver.findElement(By.xpath("//div[.='To']")).sendKeys("Hy");
		
		//driver.findElement(By.xpath("//input[@value='Select Destination']")).sendKeys("Hyderabad",Keys.ENTER);
		
		driver.findElement(By.xpath("//div[.='Departure Date']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'November ')]/ancestor::div[@data-testid='undefined-month-November-2023']//div[.='16']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'December ')]/ancestor::div[@data-testid='undefined-month-December-2023']//div[.='25']")).click();
		
		driver.findElement(By.xpath("//div[.='Passengers']/..//*[name()='svg']")).click();
		
		driver.findElement(By.xpath("//div[.='Children']/../following::div[@data-testid='Children-testID-plus-one-cta']")).click();
		
		Actions act=new Actions(driver);
		
		act.moveByOffset(0, 0).click().build().perform();
		
		driver.findElement(By.xpath("//div[.='Search Flight']")).click();
		
	}

}
