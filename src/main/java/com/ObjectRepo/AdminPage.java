package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage
{

	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space(text())='Add Admin']")
	private WebElement addAdminButton;

	public WebElement getAddAdminButton() {
		return addAdminButton;
	}

	@FindBy(xpath = "//input [@type='search']")
	private WebElement searchTextfield;

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	@FindBy(xpath = "//select[@name='example1_length']")
	private WebElement showEntriesDropown;

	public WebElement getShowEntriesDropown() {
		return showEntriesDropown;
	}

	@FindBy(xpath = "//option[@value='10']")
	private WebElement show10Enteries;

	public WebElement getShow10Enteries() {
		return show10Enteries;
	}

	@FindBy(xpath = "//option[@value='25']")
	private WebElement show25Enteries;

	public WebElement getShow25Enteries() {
		return show25Enteries;
	}

	@FindBy(xpath = "//option[@value='50']")
	private WebElement show50Enteries;

	public WebElement getShow50Enteries() {
		return show50Enteries;
	}

	@FindBy(xpath = "//option[@value='100']")
	private WebElement show100Enteries;

	public WebElement getShow100Enteries() {
		return show100Enteries;
	}

	@FindBy(xpath = "//span//i[@title='Edit Employee']")
	private WebElement editAdminIcon;

	public WebElement getEditAdminIcon() {
		return editAdminIcon;
	}

	public WebElement getDeleteAdminIcon() {
		return deleteAdminIcon;
	}

	@FindBy(xpath = "//span//i[@title='Delete Employee']")
	private WebElement deleteAdminIcon;

	public void clickOnEditAdminIcon(WebDriver driver, String adminFirstName, String hrId) {
		WebElement plusExpandIcon = driver.findElement(By.xpath("//td[text()='" + adminFirstName + "']/..//td[@class='sorting_1' and text()='" + hrId + "']"));
		plusExpandIcon.click();
		editAdminIcon.click();
	}

	public void clickOnDeleteAdminIcon(WebDriver driver, String adminFirstName, String hrId) {
		WebElement plusExpandIcon = driver.findElement(By.xpath("//td[text()='" + adminFirstName + "']/..//td[@class='sorting_1' and text()='" + hrId + "']"));
		plusExpandIcon.click();
		deleteAdminIcon.click();
	}
	
	public void clickOnAddAdminBtn()
	{
		addAdminButton.click();
	}
}

