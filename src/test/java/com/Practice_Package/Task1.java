package com.Practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");

		driver.findElement(By.xpath("//span[.='✕']")).click();

		driver.findElement(By.name("q")).sendKeys("Iphone",Keys.ENTER);

		List<WebElement> allIphones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

		for(int i=0;i<allIphones.size();i++)
		{
			String iphoneName = allIphones.get(i).getText();
			String iphonePrice = allPrices.get(i).getText();

			System.out.println(iphoneName+" ------> "+iphonePrice);
		}

	}

}
