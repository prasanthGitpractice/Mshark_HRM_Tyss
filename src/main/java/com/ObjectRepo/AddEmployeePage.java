package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.GenericUtils.WebDriverUtils;


//TESTED
public class AddEmployeePage extends WebDriverUtils
{

	//==========================Declaration=======================//
	@FindBy(xpath="(//input[@name='employee_companyid'])[1]")
	private WebElement companyIDTbx;
	@FindBy(xpath="(//input[@name='employee_firstname'])[1]")
	private WebElement firstNameTbx;
	@FindBy(xpath="(//input[@name='employee_lastname'])[1]")
	private WebElement lastNameTbx;
	@FindBy(xpath="(//input[@name='employee_middlename'])[1]")
	private WebElement middleNameTbx;
	@FindBy(xpath="(//input[@name='branches_datefrom'])[1]")
	private WebElement brnchsDateFrom;
	@FindBy(xpath="(//input[@name='branches_recentdate'])[1]")
	private WebElement brnchsRecentDate;
	@FindBy(xpath="(//select[@name='employee_department'])[1]")
	private WebElement deptDD;
	@FindBy(xpath="(//select[@name='employee_branches'])[1]")
	private WebElement branchesDD;
	@FindBy(xpath="(//input[@name='employee_position'])[1]")
	private WebElement positionTbx;
	@FindBy(xpath="(//input[@name='employee_contact'])[1]")
	private WebElement contactNoTbx;
	@FindBy(xpath="(//input[@name='employee_sss'])[1]")
	private WebElement sssTbx;
	@FindBy(xpath="(//input[@name='employee_tin'])[1]")
	private WebElement tinTbx;
	@FindBy(xpath="(//input[@name='employee_hdmf_pagibig'])[1]")
	private WebElement hdmfTbx;
	@FindBy(xpath="(//input[@name='employee_gsis'])[1]")
	private WebElement gsisTbx;
	@FindBy(xpath="(//input[@name='employee_file201'])[1]")
	private WebElement file201Btn;
	@FindBy(xpath="(//input[@name='employee_image'])[1]")
	private WebElement empPicBtn;
	@FindBy(xpath="//button[@name='emplo']")
	private WebElement saveBtn;
	@FindBy(xpath="(//button[.='Close'])[1]")
	private WebElement cancelBtn;
	
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBoxEle_Emp;
	//=========================initialization=====================//
	public AddEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//============================Getters==========================//
	public WebElement getCompanyIDTbx() {
		return companyIDTbx;
	}

	public WebElement getFirstNameTbx() {
		return firstNameTbx;
	}

	public WebElement getLastNameTbx() {
		return lastNameTbx;
	}

	public WebElement getMiddleNameTbx() {
		return middleNameTbx;
	}

	public WebElement getBrnchsDateFrom() {
		return brnchsDateFrom;
	}

	public WebElement getBrnchsRecentDate() {
		return brnchsRecentDate;
	}

	public WebElement getDeptDD() {
		return deptDD;
	}

	public WebElement getBranchesDD() {
		return branchesDD;
	}

	public WebElement getPositionTbx() {
		return positionTbx;
	}

	public WebElement getContactNoTbx() {
		return contactNoTbx;
	}

	public WebElement getSssTbx() {
		return sssTbx;
	}

	public WebElement getTinTbx() {
		return tinTbx;
	}

	public WebElement getHdmfTbx() {
		return hdmfTbx;
	}

	public WebElement getGsisTbx() {
		return gsisTbx;
	}

	public WebElement getFile201Btn() {
		return file201Btn;
	}

	public WebElement getEmpPicBtn() {
		return empPicBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}


	//======================Business Logic=======================//
	public void fillCompanyIDTbx(String companyID) {
		companyIDTbx.sendKeys(companyID);
	}

	public void fillFirstNameTbx(String firstName) {
		firstNameTbx.sendKeys(firstName);
	}

	public void fillLastNameTbx(String lastName) {
		lastNameTbx.sendKeys(lastName);
	}

	public void fillMiddleNameTbx(String middleName) {
		middleNameTbx.sendKeys(middleName);
	}

	public void clickBrnchsDateFrom(WebDriver driver) {
		mouseHoverOnWebElement(driver,brnchsDateFrom,212,0);
	}

	public void clickBrnchsRecentDate(WebDriver driver) {
		mouseHoverOnWebElement(driver,brnchsRecentDate,212,0);
	}

	public void setDeptDD(String visibleText) {
		dropDown(visibleText,deptDD);
	}

	public void setBranchesDD(String visibleText) {
		dropDown(visibleText,branchesDD);
	}
	public void fillPositionTbx(String position) {
		positionTbx.sendKeys(position);
	}

	public void fillContactNoTbx(String contact) {
		contactNoTbx.sendKeys(contact);
	}

	public void fillSssTbx(String sss) {
		sssTbx.sendKeys(sss);
	}

	public void fillTinTbx(String tin) {
		tinTbx.sendKeys(tin);
	}

	public void fillHdmfTbx(String hdmf) {
		hdmfTbx.sendKeys(hdmf);
	}

	public void fillGsisTbx(String gsis) {
		gsisTbx.sendKeys(gsis);
	}

	public void clickFile201Btn() {
		file201Btn.click();
	}

	public void clickEmpPicBtn() {
		empPicBtn.click();
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public void clickCancelBtn() {
		cancelBtn.click();
	}	
	
	public void searchEmployee(String empName)
	{
		searchBoxEle_Emp.sendKeys(empName);
	}
	
	public void deleteEmployee(WebDriver driver, String employeeId) throws Throwable
	{
		driver.findElement(By.xpath("//tbody//td[.='"+employeeId+"']")).click();
		//String employeeFirstName = driver.findElement(By.xpath("//td[text()='"+employeeId+"']/../td[3]")).getText();
		driver.findElement(By.xpath("//span[.='Action']/..//i[@title='Delete Employee']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='modal fade show']//div[@class='modal-content']//button[.='Delete']")).click();
	}
	
	public void uploadEmpFile201(String path)
	{
		file201Btn.sendKeys(path);
		
	}
	
	public void uploadEmpPic(String path)
	{
		empPicBtn.sendKeys(path);
		
	}
	
	
}

