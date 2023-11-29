package com.Practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calender_RedBus 
{

	public static void main(String[] args) 
	{

		WebDriver  driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String searchCountry="Australia";
		boolean flag=true;
		List<WebElement> allCountries = driver.findElements(By.xpath("//span[@class='u-hide-phablet']"));
		for(WebElement country:allCountries)
		{
			String ActCountry=country.getText();
			if(ActCountry.equalsIgnoreCase(searchCountry))
			{
				String COUNTRY=country.getText();
				String matches=driver.findElement(By.xpath("//span[@class='u-hide-phablet']/parent::td/following-sibling::td[1]")).getText();
				String points=driver.findElement(By.xpath("//span[@class='u-hide-phablet']/parent::td/following-sibling::td[2]")).getText();
				String rating=driver.findElement(By.xpath("//span[@class='u-hide-phablet']/parent::td/following-sibling::td[3]")).getText();
				System.out.println(COUNTRY+" "+matches+" "+points+" "+rating+" ");
				break;
			}
			
		}
		
		if(flag==false)
			System.out.println(searchCountry+" is not in the List");
		/*
		 * System.out.println("======================");
		 * 
		 * for(WebElement country:allCountries) { String ActCountry=country.getText();
		 * System.out.println(ActCountry);
		 * 
		 * }
		 */
	}

}
