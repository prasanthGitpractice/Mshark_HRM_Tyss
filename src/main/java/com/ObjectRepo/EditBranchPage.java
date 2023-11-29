package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditBranchPage 
{

	public EditBranchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_name']")
	private WebElement branchNameTextfield;

	public WebElement getBranchNameTextfield() {
		return branchNameTextfield;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_name']/../../descendant::button[text()='Update']")
	private WebElement updateButton;

	public WebElement getUpdateButton() {
		return updateButton;
	}

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_name']/../../descendant::button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}

	public void editBranch(WebDriver driver, String branchNameToUpdate) {
		branchNameTextfield.clear();
		branchNameTextfield.sendKeys(branchNameToUpdate);
		updateButton.click();
	}
}
