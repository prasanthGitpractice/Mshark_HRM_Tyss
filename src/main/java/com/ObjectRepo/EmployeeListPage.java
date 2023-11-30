package com.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.GenericUtils.WebDriverUtils;

public class EmployeeListPage 
{
	// Declare Webelements
	@FindBy(xpath = "//button[contains(.,'Add Employee')]")
	private WebElement addEmpBtn;
	
	@FindBy(xpath = "//div[@class='card-body']//input[@type='search']")
	private WebElement searchBoxEle;
		
	@FindBy(xpath="//tbody/tr/td[.='kav']/following-sibling::td[@style='width: 10%']/i[@title='Edit Employee']")
	private WebElement editEmpBtn;
	
	@FindBy(xpath= "//tbody/tr/td[.='kav']/following-sibling::td[@style='width: 10%']/i[@title='Delete Employee']")
	private WebElement delEmpBtn;
	
	@FindBy(xpath = "//tbody/tr/td[.='kav']/following-sibling::td[@style='width: 10%']/object")
	private WebElement downloadEmpBtn;
	
	@FindBy(name = "example1_length")
	private WebElement noOfEntriesDDele;
	
	@FindBy(xpath = "//option[@value='100']")
	private WebElement entryEle_100;
	
	//Initialize WebElements
	public EmployeeListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Generate getters
	public WebElement getAddEmpBtn() {
		return addEmpBtn;
	}

	public WebElement getSearchBoxEle() {
		return searchBoxEle;
	}

	//not dynamic
	public WebElement getEditEmpBtn() {
		return editEmpBtn;
	}

	//not dynamic
	public WebElement getDelEmpBtn() {
		return delEmpBtn;
	}

	//not dynamic
	public WebElement getDownloadEmpBtn() {
		return downloadEmpBtn;
	}
	
	// Develope Business Libraries
	
	//This method return true if particular employee is present else it will return false
	public boolean isEmployeePresent(WebDriver driver, String empName, String expEmpFname)
	{
		searchBoxEle.sendKeys(empName);
		WebDriverUtils wutil=new WebDriverUtils();
		String entryvalue = entryEle_100.getText();
		wutil.dropDown(noOfEntriesDDele, entryvalue);
		
		List<WebElement> allFirstnames = driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));
		boolean flag=false;
		for(WebElement fName : allFirstnames)
		{
			String actEmpFname = fName.getText();
			if(actEmpFname.equalsIgnoreCase(expEmpFname))
			{
				flag=true;
				break;
			}
			
		}
		
		if(!flag)
		{
			System.out.println(expEmpFname+" is present in employee List page");
			return true;
		}
		else
		{
			System.out.println(expEmpFname+" is not present in employee List page");
			return false;
		}
	}
	
	public void searchEmployee(String employeeId)
	{
		searchBoxEle.sendKeys(employeeId);
	}
	
	public void clickOnEditButton()
	{
		editEmpBtn.click();
	}
	
	public String getEmpNameByUsingEmpID(WebDriver driver, String employeeId)
	{
		String actualEmployeeFirstName = driver.findElement(By.xpath("//td[text()='" + employeeId + "']/../td[3]")).getText();
		return actualEmployeeFirstName;
	}
	
	public String getActualContactNumberOfEmp(WebDriver driver, String employeeId)
	{
		WebDriverUtils wutil=new WebDriverUtils();
		wutil.waitUntilEleToBeVisible(driver, searchBoxEle, 20);	
		searchBoxEle.sendKeys(employeeId);
		driver.findElement(By.xpath("//tbody/tr/td[.='"+employeeId+"']")).click();
		driver.findElement(By.xpath("//tbody/tr/td[.='"+employeeId+"']/../following::i[@title='Edit Employee']")).click();
		String actualContactNo = driver.findElement(By.xpath("(//div[@class='form-group']//input[@name='employee_contact'])[2]")).getAttribute("value");
		EditEmployeePage edtemp=new EditEmployeePage(driver);
		edtemp.getCloaseBtn().click();
		return actualContactNo;
	}
	
	public String getActualEmpID(WebDriver driver, String employeeId)
	{
		searchBoxEle.sendKeys(employeeId);
		String actEmployeeId = driver.findElement(By.xpath("//td[@class='sorting_1']")).getText();
		return actEmployeeId;
	}
	
	public void editEmployee(WebDriver driver, String empID)
	{
		driver.findElement(By.xpath("//tbody/tr/td[.='"+empID+"']")).click();
		driver.findElement(By.xpath("//tbody/tr/td[.='"+empID+"']/../following::i[@title='Edit Employee']")).click();
	}
	

}
