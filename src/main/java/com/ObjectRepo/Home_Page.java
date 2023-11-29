package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.GenericUtils.WebDriverUtils;

public class Home_Page
{
	// Declare WebElements
	@FindBy(xpath = "//p[.='Dashboard']")
	private WebElement dashBoardEle;
	
	@FindBy(xpath = "//i[@class='nav-icon fa fa-handshake']")
	private WebElement corporateEle;
	
	@FindBy(xpath = "//a[@href='Add_corporate.php']")
	private WebElement addCorporateEle;
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-code-branch']")
	private WebElement branchEle;
	
	@FindBy(xpath = "//a[@href='Add_braches.php']")
	private WebElement addBranchesEle;
	
	@FindBy(xpath = "//p[contains(text(),'EMPLOYEE')]")
	private WebElement employeeEle;
	
	@FindBy(xpath = "//li[@class='nav-item']/a[@href='Add_employee.php']")
	private WebElement addEmployeeEle;
	
	@FindBy(xpath = "//p[contains(text(),'ADMIN')]")
	private WebElement adminEle;
	
	@FindBy(xpath = "//a[@href='Add_admin.php']")
	private WebElement addAdminEle;
	
	@FindBy(xpath= "//span[.='Employee']/following-sibling::span")
	private WebElement dbEmployeeCountEle;
	
	@FindBy(xpath= "//span[.='Corporate']/following-sibling::span")
	private WebElement dbCorporateCountEle;
	
	@FindBy(xpath= "//span[.='Braches']/following-sibling::span")
	private WebElement dbBranchesCountEle;
	
	@FindBy(xpath= "//span[.='Admin Account']/following-sibling::span")
	private WebElement dbAdminCountEle;
	
	@FindBy(xpath= "//i[@class='fa fa-user']")
	private WebElement profileICONEle;
	
	@FindBy(xpath= "//a[@href='log_out.php']")
	private WebElement logOutBtn;
	
	@FindBy(className = "d-block")
	private WebElement currentUserEle;
	
	// Initialize Elements
	public Home_Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	// Getters
	public WebElement getDashBoardEle() {
		return dashBoardEle;
	}

	public WebElement getCorporateEle() {
		return corporateEle;
	}

	public WebElement getBranchEle() {
		return branchEle;
	}

	public WebElement getEmployeeEle() {
		return employeeEle;
	}

	public WebElement getAdminEle() {
		return adminEle;
	}

	public WebElement getAddCorporateEle() {
		return addCorporateEle;
	}

	public WebElement getAddBranchesEle() {
		return addBranchesEle;
	}

	public WebElement getAddEmployeeEle() {
		return addEmployeeEle;
	}

	public WebElement getAddAdminEle() {
		return addAdminEle;
	}

	public WebElement getDbEmployeeCountEle() {
		return dbEmployeeCountEle;
	}

	public WebElement getDbCorporateCountEle() {
		return dbCorporateCountEle;
	}

	public WebElement getDbBranchesCountEle() {
		return dbBranchesCountEle;
	}

	public WebElement getDbAdminCountEle() {
		return dbAdminCountEle;
	}

	public WebElement getProfileICONEle() {
		return profileICONEle;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public WebElement getCurrentUserEle() {
		return currentUserEle;
	}
	
	// Business Libraries
	public void navigateToAddCorporate() throws Throwable
	{
		corporateEle.click();
		Thread.sleep(5000);		
		addCorporateEle.click();
		
	}
	
	public void navigateToAddBranches()
	{
		branchEle.click();
		addBranchesEle.click();
		
	}
	
	public void navigateToAddEmployee(WebDriver driver) throws Throwable
	{
		employeeEle.click();
		WebDriverUtils wutil=new WebDriverUtils();
		wutil.waitUntilEleToBeClickable(driver, addEmployeeEle, 10);
		addEmployeeEle.click();		
	}
	
	public void navigateToAddAdmin()
	{
		adminEle.click();
		addAdminEle.click();
		
	}
	
	public int getDBEmployeeCount()
	{
		String empCount = dbEmployeeCountEle.getText();
		int emp_Count = Integer.parseInt(empCount);
		return emp_Count;
	}
	
	public int getDBCorporateCount()
	{
		String corpCount = dbCorporateCountEle.getText();
		int Corp_Count = Integer.parseInt(corpCount);
		return Corp_Count;
	}
	
	public int getDBBranchesCount()
	{
		String branchesCount = dbBranchesCountEle.getText();
		int branches_Count = Integer.parseInt(branchesCount);
		return branches_Count;
	}
	
	public int getDBAdminCount()
	{
		String adminCount = dbAdminCountEle.getText();
		int admin_Count = Integer.parseInt(adminCount);
		return admin_Count;
	}
	
	public String getCurrentUser()
	{
		String CurrentUserName = currentUserEle.getText();
		return CurrentUserName;
	}
	
	public void naviagateToHomePage()
	{
		dashBoardEle.click();
	}
	
	public void logOutApp() throws Throwable
	{
		Thread.sleep(10000);
		profileICONEle.click();
		logOutBtn.click();
	}
	
	public void clcikOnDashBoard()
	{
		dashBoardEle.click();
	}
	
}
