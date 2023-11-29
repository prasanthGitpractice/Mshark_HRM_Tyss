package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBranchesPage 
{

	public AddBranchesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form//input[@name='branches_name']")
	private WebElement branchNameTextfield;

	public WebElement getBranchNameTextfield() {
		return branchNameTextfield;
	}

	@FindBy(xpath = "//form//button[text()='Save']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath = "//form//button[text()='Close']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}

	public void addBranche(WebDriver driver, String branchName) {
		branchNameTextfield.clear();
		branchNameTextfield.sendKeys(branchName);
		saveButton.click();
	}
}

