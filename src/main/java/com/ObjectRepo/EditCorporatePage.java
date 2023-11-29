package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCorporatePage 
{
	//Declare Webelements
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//input[@name='corporate_name']")
	private WebElement CorpName_edtEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//button[.='Close']")
	private WebElement closeBtn_edtEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//button[.='Update']")
	private WebElement updateBtn_edtEle;
	
	//Initialize Webelements
	public EditCorporatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// Generate getters
	public WebElement getCorpName_edtEle() {
		return CorpName_edtEle;
	}

	public WebElement getCloseBtn_edtEle() {
		return closeBtn_edtEle;
	}

	public WebElement getUpdateBtn_edtEle() {
		return updateBtn_edtEle;
	}
	
	// Business Libraries
	public void updateCorporate(String newCorpName)
	{
		CorpName_edtEle.sendKeys(newCorpName);
		updateBtn_edtEle.click();
	}
	
}
