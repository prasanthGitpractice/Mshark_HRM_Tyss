package com.Practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.amazon.in/");

		try {

			driver.findElement(By.id("nav-bb-search")).sendKeys("Iphone",Keys.ENTER);

		}
		catch (Exception e) {

			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone",Keys.ENTER);
		}

		List<WebElement> allIphones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		for(int i=0;i<allIphones.size();i++)
		{
			String iphonePrice = allPrices.get(i).getText();
			String con_price=iphonePrice.replace(",", "");
			//System.out.println(con_price);
			
			int price=Integer.parseInt(con_price);
			//int price=Integer.valueOf(iphonePrice);
			if(price<=60000)
			{
				String iphoneName = allIphones.get(i).getText();
				System.out.println(iphoneName+" ------> "+price);
			}

			
		}

	}

}
