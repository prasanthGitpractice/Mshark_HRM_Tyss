package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		
		String searchCountry="Japan";
		
		String resultedCountry = driver.findElement(By.xpath("//span[.='"+searchCountry+"']")).getText();
		
		/*
		 * List<WebElement> countryNames =
		 * driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		 * List<WebElement> golds =
		 * driver.findElements(By.xpath("//div[@title='Gold']")); List<WebElement>
		 * silvers = driver.findElements(By.xpath("//div[@title='Silver']"));
		 * List<WebElement> bronzes =
		 * driver.findElements(By.xpath("//div[@title='Bronze']"));
		 * 
		 * for(int i=0;i<countryNames.size();i++) { int x=i+1; String country =
		 * countryNames.get(i).getText(); String gold = golds.get(i).getText(); String
		 * silver = silvers.get(i).getText(); String bronze = bronzes.get(i).getText();
		 * String total = driver.findElement(By.xpath(
		 * "//div[@class='line']/preceding-sibling::div[@data-medal-id='total-medals-row-"
		 * +x+"']")).getText();
		 * 
		 * System.out.println(country+" -->Gold-"+gold+" Silver-"+silver+" Bronze-"
		 * +bronze+"  Total Medals-"+total); }
		 */
		
		if(resultedCountry.equalsIgnoreCase(searchCountry))
		{
			
			String noOfGold = driver.findElement(By.xpath("//span[.='"+searchCountry+"']/../following-sibling::div[@title='Gold']")).getText();
			
			String noOfSilver = driver.findElement(By.xpath("//span[.='"+searchCountry+"']/../following-sibling::div[@title='Silver']")).getText();
			
			String noOfBronze = driver.findElement(By.xpath("//span[.='"+searchCountry+"']/../following-sibling::div[@title='Bronze']")).getText();
		
			String totalNoOfMedals = driver.findElement(By.xpath("//span[.='"+searchCountry+"']/../following-sibling::div[4]")).getText();
			
			System.out.println(resultedCountry+" -->Gold-"+noOfGold+" Silver-"+noOfSilver+" Bronze-"+noOfBronze+"  Total Medals-"+totalNoOfMedals);
		}
		
		else
			System.out.println(searchCountry+" is not in the List");
		
	}

}
