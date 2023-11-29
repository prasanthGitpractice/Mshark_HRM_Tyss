package com.Practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.cricbuzz.com/");
		
		driver.findElement(By.xpath("//a[.='Live Scores']")).click();
		
		Thread.sleep(5000);	
		
		List<WebElement> liveMatches = driver.findElements(By.xpath("//div[@class='cb-col-100 cb-col cb-schdl']/following-sibling::nav/a[.='Live Score']"));
		
		for(WebElement e:liveMatches)
		{
			String data = e.getText();
			System.out.println(data);
		}
	
	}

}
