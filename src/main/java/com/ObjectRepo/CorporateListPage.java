package com.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.GenericUtils.WebDriverUtils;

public class CorporateListPage extends WebDriverUtils
{
	// Declare Webelements
	@FindBy(xpath = "//div[@class='card-header']//button[contains(.,'Add Corporate')]")
	private WebElement addCorporateBtnEle;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBoxEle;
	
	@FindBy(name = "example1_length")
	private WebElement showNoOfEntriesDropDown;
	
	@FindBy(xpath= "//option[@value='100']")
	private WebElement Value_100;
	
	// Initialize Elements
	public CorporateListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Generate Getters
	public WebElement getAddCorporateBtnEle() {
		return addCorporateBtnEle;
	}

	public WebElement getSearchBoxEle() {
		return searchBoxEle;
	}
	
	public WebElement getShowNoOfEntriesDD() {
		return showNoOfEntriesDropDown;
	}
	
	//Business Libraries
	//click on edit Corporate button Edit Employee
	public void clickOnEditCoraporateBtn(WebDriver driver, String corporateName)
	{
		driver.findElement(By.xpath("//tbody/tr/td[.='"+corporateName+"']/following-sibling::td/button[.='Edit']")).click();
	}
	
	//click on Delete Corporate button Edit Employee
	public void clickOnDeleteCorporateBtn(WebDriver driver, String corporateName)
	{
		driver.findElement(By.xpath("//tbody/tr/td[.='"+corporateName+"']/following-sibling::td/button[.='Delete']")).click();
	}
	
	//search Corporate name
	public void searchCorporate(String corporateName)
	{
		searchBoxEle.sendKeys(corporateName);
	}
	
	//Click on AddCorporate Button
	public void clickOnAddCorporateBtn()
	{
		addCorporateBtnEle.click();
	}
	
	//Validate a corporate in Corporate List page
	// This method returns "true" if particular Corporate name is present in list...else it returns "false"
	public boolean isCorporatePresentInList(WebDriver driver, String expectedCorporatename) 
	{
		searchCorporate(expectedCorporatename);
		boolean flag=false;
		String noOfEntriesDropDownvalue = Value_100.getText();
		dropDown(showNoOfEntriesDropDown, noOfEntriesDropDownvalue);
		List<WebElement> allCorporatenames = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		
		for(WebElement Corpname : allCorporatenames)
		{
			String actualCorporatename = Corpname.getText();
			if(actualCorporatename.equalsIgnoreCase(expectedCorporatename))
			{
				flag = true;
				break;
			}
		}
		
		if(!flag)
			return true;
		else
			return false;
		
	}
	
}
