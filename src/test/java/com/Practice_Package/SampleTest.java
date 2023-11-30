package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest 
{
	WebDriver driver;
	@Test
	public void m1Test() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		Thread.sleep(Duration.ofSeconds(5));
		System.out.println(driver.getTitle());
		driver.quit();
		System.out.println("Browser Closed");
		
	}
}
