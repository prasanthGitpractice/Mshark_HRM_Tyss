package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditEmployeePage 
{
	//@FindBy(xpath= "//div[@class='modal fade show']//div[@class='modal-header']/following-sibling::div[@class='modal-body']//input[@name='employee_companyid']")
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_companyid']")
	private WebElement compID;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_firstname']")
	private WebElement empFnameEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_lastname']")
	private WebElement empLNameEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_middlename']")
	private WebElement empMidNameEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_datefrom']")
	private WebElement brnchDateFromEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_recentdate']")
	private WebElement recentdateEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_position']")
	private WebElement empPositionEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_contact']")
	private WebElement empContactEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_sss']")
	private WebElement empSSSEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_tin']")
	private WebElement empTINEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_hdmf_pagibig']")
	private WebElement empHDMFEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_gsis']")
	private WebElement empGSISEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_file201']")
	private WebElement File201Ele;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_image']")
	private WebElement empPICEle;
	
	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Close']")
	private WebElement cloaseBtn;
	
	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Update']")
	private WebElement updateBtn;
	
	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_department']")
	private WebElement empDeptDDEle;

	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_branches']")
	private WebElement empBranchDDEle;
	
	
	// initialize WebElements
	public EditEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// Generate Getter methods
	public WebElement getCompID() {
		return compID;
	}

	public WebElement getEmpFnameEle() {
		return empFnameEle;
	}

	public WebElement getEmpLNameEle() {
		return empLNameEle;
	}

	public WebElement getEmpMidNameEle() {
		return empMidNameEle;
	}

	public WebElement getBrnchDateFromEle() {
		return brnchDateFromEle;
	}

	public WebElement getRecentdateEle() {
		return recentdateEle;
	}

	public WebElement getEmpPositionEle() {
		return empPositionEle;
	}

	public WebElement getEmpContactEle() {
		return empContactEle;
	}

	public WebElement getEmpSSSEle() {
		return empSSSEle;
	}

	public WebElement getEmpTINEle() {
		return empTINEle;
	}

	public WebElement getEmpHDMFEle() {
		return empHDMFEle;
	}

	public WebElement getEmpGSISEle() {
		return empGSISEle;
	}

	public WebElement getFile201Ele() {
		return File201Ele;
	}

	public WebElement getEmpPICEle() {
		return empPICEle;
	}

	public WebElement getCloaseBtn() {
		return cloaseBtn;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public WebElement getEmpDeptDDEle() {
		return empDeptDDEle;
	}


	public WebElement getEmpBranchDDEle() {
		return empBranchDDEle;
	}
	
	//Business Library
	
	public void updateEmployee(WebDriver driver, String updatedName, String employeeId, String empFileAbsolutepath, String profilePicAbsolutepath) throws Throwable
	{
		empFnameEle.clear();
		empFnameEle.sendKeys(updatedName);
		driver.findElement(By.xpath("(//input[@value='"+employeeId+"'])[1]/ancestor::div[@class='modal-content']/descendant::input[@name='employee_file201']")).sendKeys(empFileAbsolutepath);
		driver.findElement(By.xpath("(//input[@value='"+employeeId+"'])[1]/ancestor::div[@class='modal-content']/descendant::input[@name='employee_image']")).sendKeys(profilePicAbsolutepath);
		
		updateBtn.click();
		
	}
	
	
	
}
