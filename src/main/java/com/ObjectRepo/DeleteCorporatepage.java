package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCorporatepage 
{
	
	// declare webelements
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//input[@name='corporate_name']")
	private WebElement corpName_dltEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//button[.='Close']")
	private WebElement colseBtn_dltEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//button[.='Delete']")
	private WebElement deleteBtn_dltEle;
	
	//initialize Webelements
	public DeleteCorporatepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// Generate Gettares
	public WebElement getCorpName_dltEle() {
		return corpName_dltEle;
	}

	public WebElement getColseBtn_dltEle() {
		return colseBtn_dltEle;
	}

	public WebElement getDeleteBtn_dltEle() {
		return deleteBtn_dltEle;
	}
	
	// Business Library
	public void deleteCorporate()
	{
		deleteBtn_dltEle.click();
	}
	
	
	
}
