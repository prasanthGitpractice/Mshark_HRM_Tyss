package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEmployeepage 
{
	// Declare WebElements
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-header']/following-sibling::div[contains(@class,'modal-footer')]/button[.='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-header']/following-sibling::div[contains(@class,'modal-footer')]/button[.='Close']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-header']//span")
	private WebElement crossMarkEle;
	
	//Initialize webelements
	public DeleteEmployeepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Generate Getters
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public WebElement getCrossMarkEle() {
		return crossMarkEle;
	}
	
	// Develope Business Libraries
	
	//Delete Emploeye
	public void deleteEmployee()
	{
		deleteBtn.click();
	}
	
	
}
