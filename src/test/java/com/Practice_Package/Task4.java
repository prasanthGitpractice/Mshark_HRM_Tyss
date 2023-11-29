package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.prokabaddi.com/standings");
		
		String teamName="Puneri Paltan";
		
		/*
		 * List<WebElement> teams =
		 * driver.findElements(By.xpath("//div[@class='table-data team']"));
		 * List<WebElement> matchesPlayed =
		 * driver.findElements(By.xpath("//div[@class='table-data matches-play']"));
		 * List<WebElement> matchesWon =
		 * driver.findElements(By.xpath("//div[@class='table-data matches-won']"));
		 * List<WebElement> matchesLost =
		 * driver.findElements(By.xpath("//div[@class='table-data matches-lost']"));
		 * List<WebElement> matchesDraw =
		 * driver.findElements(By.xpath("//div[@class='table-data matches-draw']"));
		 * List<WebElement> scoreDiff =
		 * driver.findElements(By.xpath("//div[@class='table-data score-diff']"));
		 * List<WebElement> recentForm =
		 * driver.findElements(By.xpath("//div[@class='table-data form']"));
		 * List<WebElement> points =
		 * driver.findElements(By.xpath("//div[@class='table-data points']"));
		 * 
		 * 
		 * 
		 * //List<WebElement>
		 * teams=driver.findElements(By.xpath("//div[@class='row-head']")); for(int
		 * i=0;i<teams.size();i++) { String teamName = teams.get(i).getText(); String
		 * mPlayed = matchesPlayed.get(i).getText(); String mWon =
		 * matchesWon.get(i).getText(); String mLost = matchesLost.get(i).getText();
		 * String mDraw = matchesDraw.get(i).getText(); String mscoreDiff =
		 * scoreDiff.get(i).getText(); String form = recentForm.get(i).getText(); String
		 * point = points.get(i).getText();
		 * 
		 * System.out.println(teamName+" "+mPlayed+" "+mWon+" "+mLost+" "+mDraw+" "
		 * +mscoreDiff+" "+form+" "+point); }
		 */
		
		String info = driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='row-head']")).getText();
		
		System.out.println(info);
	}

}
