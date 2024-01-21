package com.Practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("tv", Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@id='reviewsRefinements']//span[.='4 Stars & Up']/../following-sibling::span")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement result = driver.findElement(By.xpath("//span[.='Results']"));
		wait.until(ExpectedConditions.visibilityOf(result));
		
		List<WebElement> allTvs = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		
		List<WebElement> tvPrices = driver.findElements(By.xpath("//div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row']//span[@class='a-price-whole']"));
	
		for(int i=0; i<allTvs.size(); i++)
		{
			String price = tvPrices.get(i).getText();
			String np= price.replace(",", "");
			
			int Price = Integer.parseInt(np);
			
			if(Price>=20000 && Price<=30000)
			{
				System.out.println(allTvs.get(i).getText()+"---------->"+Price);
			}	
		}
		
	
	}

}
