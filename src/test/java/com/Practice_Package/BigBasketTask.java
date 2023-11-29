package com.Practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


//div[@class='card-foreground    ']//a[@data-bi-cn='Learn more'] ------------------Xpath for learn more in microsoft.com
public class BigBasketTask 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='Header___StyledCategoryMenu2-sc-19kl9m3-13 ibVaum']")).click();
		WebElement itemCategory = driver.findElement(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']//ul/li/a[.='Fruits & Vegetables']"));
		Actions act=new Actions(driver);
		act.moveToElement(itemCategory).perform();
		
		WebElement itemSubCategory = driver.findElement(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']//ul[2]/li[.='Cuts & Sprouts']"));
		act.moveToElement(itemSubCategory).perform();
		
		List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']//ul[3]/li"));		

		
		for(WebElement item:allItems)
		{
			System.out.println(item.getText());
		}
	}

}
