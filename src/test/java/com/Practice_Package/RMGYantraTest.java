package com.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGYantraTest 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://rmgtestingserver:8084/");

		Thread.sleep(5000);

		WebElement un = driver.findElement(By.id("usernmae"));

		un.sendKeys("rmgyantra");

		WebElement pwd = driver.findElement(By.id("inputPassword"));

		pwd.sendKeys("rmgy@9999");

		driver.findElement(By.xpath("//button[.='Sign in']")).click();

		driver.findElement(By.xpath("//a[.='Projects']")).click();

		driver.findElement(By.xpath("//span[.='Create Project']")).click();

		driver.findElement(By.name("projectName")).sendKeys("TY_dummy2_sdet52");

		driver.findElement(By.name("createdBy")).sendKeys("VijayaLakshmi");

		WebElement dd_projectStatus = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));

		Select s=new Select(dd_projectStatus);

		s.selectByVisibleText("On Gogin");

		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		String actualName_project="TY_dummy2_sdet52";
		boolean flag=false;
		
		// Register driver
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);

		// get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

		//create statement
		Statement state = con.createStatement();
		String query = "select* from project;";

		// Execute Query
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			String project_name = result.getString(4);
			if(project_name.equalsIgnoreCase(actualName_project))
			{
				System.out.println("project got created Successfully");
				flag=true;
				break;
			}
		}		
		
		if(!flag)
			System.out.println("project created was failed");

		// Close Database
		con.close();











	}

}
