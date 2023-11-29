package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCorporatePage 
{
	// Declare Webelements
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//input[@name='corporate_name']")
	private WebElement corpNameEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//button[.='Close']")
	private WebElement cancelBtnEle;
	 
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-content']//button[.='Save']")
	private WebElement saveBtnEle;

	//Initialize WebElements
	public AddCorporatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// Generate Getters
	public WebElement getCorpNameEle() {
		return corpNameEle;
	}

	public WebElement getCancelBtnEle() {
		return cancelBtnEle;
	}

	public WebElement getSaveBtnEle() {
		return saveBtnEle;
	}
	
	//Business Libraries
	public void createNewCorporate(String Corp_Name)
	{
		//corpNameEle.clear();
		corpNameEle.sendKeys(Corp_Name);
		saveBtnEle.click();
	}

}
