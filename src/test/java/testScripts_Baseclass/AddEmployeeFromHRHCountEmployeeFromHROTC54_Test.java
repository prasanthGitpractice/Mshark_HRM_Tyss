package testScripts_Baseclass;

import java.io.File;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.ExcelUtils;
import com.HRM.GenericUtils.FileUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.AddEmployeePage;
import com.ObjectRepo.EmployeeListPage;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

// Tested-now
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class AddEmployeeFromHRHCountEmployeeFromHROTC54_Test extends BaseClass
{
	@Test
	public void tc54() throws Throwable 
	{
		ExcelUtils eUtil=new ExcelUtils();
		FileUtils fUtil=new FileUtils();
		WebDriverUtils wUtil=new WebDriverUtils();

		String USERNAME = fUtil.readDataFromPropertyFile("userEmail");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		wUtil.waitForpageLoad(driver, 20);
		wUtil.waitforPageLoadImplicitly(driver, 20);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginAsHrHead(USERNAME, PASSWORD, lp.getDdEle_hrHead());
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		Home_Page hp=new Home_Page(driver);
		EmployeeListPage emplp=new EmployeeListPage(driver);

		try
		{
			hp.navigateToAddEmployee(driver);
			emplp.getAddEmpBtn().click();

		}
		catch (Exception e) 
		{
			emplp.getAddEmpBtn().click();				
		}	
		
		eUtil.readMultipleDataFromExcel("TC_54", driver, 13, 15);

		String employeeDepartment = eUtil.readDataFromExcel("TC_54", 2, 4);
		AddEmployeePage addEmp=new AddEmployeePage(driver);
		WebElement departmentDD = addEmp.getDeptDD();
		wUtil.dropDown(employeeDepartment, departmentDD);

		String employeeBranch = eUtil.readDataFromExcel("TC_54", 2, 7);
		WebElement branchesDD = addEmp.getBranchesDD();
		wUtil.dropDown(employeeBranch, branchesDD);

		File empFile = new File("C:\\Users\\PRASANTH\\Downloads\\CRM notes.pdf");
		String empFileAbsolutepath = empFile.getAbsolutePath();
		addEmp.uploadEmpFile201(empFileAbsolutepath);
		
		File profilePic = new File("C:\\Users\\PRASANTH\\Pictures\\Screenshots\\Screenshot 2023-11-10 155000.png");
		String profilePicAbsolutepath = profilePic.getAbsolutePath();
		addEmp.uploadEmpPic(profilePicAbsolutepath);
		addEmp.clickSaveBtn();
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		hp.logOutApp();

		wUtil.waitForAlertNswitchNAccept(driver);

		String hrOfficerUserEmail = eUtil.readDataFromExcel("TC_54", 7, 10);
		String hrOfficerPasswors = eUtil.readDataFromExcel("TC_54", 8, 10);
		lp.loginAsHrOfficer(hrOfficerUserEmail, hrOfficerPasswors, lp.getDdEle_hrOfficer());
		wUtil.waitForAlertNswitchNAccept(driver);
		
		String expEmployeeId = eUtil.readDataFromExcel("TC_54", 2, 16);

		try
		{
			hp.navigateToAddEmployee(driver);
			wutil.waitUntilEleToBeVisible(driver, emplp.getSearchBoxEle(), 100);
		}
		catch (Exception e) 
		{
			boolean flag=true;
			while(flag)
			{
				try
				{				
					wutil.waitUntilEleToBeVisible(driver, emplp.getSearchBoxEle(), 100);
					flag=false;
				}
				catch(Exception e1)
				{

				}
			}

		}
		
		
		String actEmployeeId = emplp.getActualEmpID(driver, expEmployeeId);
		
		Assert.assertEquals(actEmployeeId, expEmployeeId);
		
		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);
	}

}
