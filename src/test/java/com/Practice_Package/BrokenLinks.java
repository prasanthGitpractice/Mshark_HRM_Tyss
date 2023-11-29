package com.Practice_Package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks 
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int TotalnoOfLinks=allLinks.size();
		System.out.println(TotalnoOfLinks);
		
		ArrayList<String> BrokenLinks=new ArrayList<String>();
		
		for(int i=0; i<allLinks.size();i++)
		{
			
			String link=allLinks.get(i).getAttribute("href");
			URL url=null;
			int StatusCode=0;
			try {
				url = new URL(link);
				HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
				StatusCode = urlConnection.getResponseCode();
				
				if(StatusCode>=400)
				{
					BrokenLinks.add(link);
					System.out.println(link+" ------------> "+StatusCode);
				}
				
			} catch (Exception e1) {
				BrokenLinks.add(link);
				e1.printStackTrace();
				continue;
			}
			
		}
		int noOfBrokenLinks=BrokenLinks.size();
		System.out.println(noOfBrokenLinks);
		driver.quit();
		
	}

}
