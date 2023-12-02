package testScripts_Baseclass;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.ExcelUtils;
import com.HRM.GenericUtils.FileUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.EditEmployeePage;
import com.ObjectRepo.EmployeeListPage;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

//Tested-now
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class EditEmployeeFromHRACheckFromHRHTC24_Test extends BaseClass
{
	@Test
	public void tc24() throws Throwable 
	{
		ExcelUtils eUtil=new ExcelUtils();
		FileUtils fUtil=new FileUtils();
		WebDriverUtils wUtil=new WebDriverUtils();

		wUtil.waitForpageLoad(driver, 20);
		wUtil.waitforPageLoadImplicitly(driver, 60);

		String hrAssistantUserEmail = eUtil.readDataFromExcel("TC_24", 3, 1);
		String hrAssistantPasswors = eUtil.readDataFromExcel("TC_24", 4, 1);
		String hrtype = eUtil.readDataFromExcel("TC_24", 2, 1);
	
		LoginPage lp=new LoginPage(driver);
		lp.loginAsHrAssistant(hrAssistantUserEmail, hrAssistantPasswors, hrtype);
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		Home_Page hp=new Home_Page(driver);

		String employeeId = eUtil.readDataFromExcel("TC_24", 2, 4);
		EmployeeListPage emplp=new EmployeeListPage(driver);
		
		try
		{
			hp.navigateToAddEmployee(driver);
			wUtil.waitUntilEleToBeVisible(driver, emplp.getSearchBoxEle(), 100);
		}
		catch (Exception e) 
		{
			boolean flag=true;
			while(flag)
			{
				try
				{
					wUtil.waitUntilEleToBeVisible(driver, emplp.getSearchBoxEle(), 100);
					flag=false;
				}
				catch (Exception e1) 
				{
					// TODO: handle exception
				}
			}

		}
		
		emplp.getSearchBoxEle().sendKeys(employeeId);
		emplp.editEmployee(driver, employeeId);
		
		String employeeFirstNameToModify = eUtil.readDataFromExcel("TC_24",3, 4);	
		File empFile = new File("C:\\Users\\PRASANTH\\Downloads\\CRM notes.pdf");
		String empFileAbsolutepath = empFile.getAbsolutePath();
		File profilePic = new File("C:\\Users\\PRASANTH\\Pictures\\Screenshots\\Screenshot 2023-11-10 155000.png");
		String profilePicAbsolutepath = profilePic.getAbsolutePath();
		
		EditEmployeePage edtemp=new EditEmployeePage(driver);
		edtemp.updateEmployee(driver,employeeFirstNameToModify, employeeId, empFileAbsolutepath, profilePicAbsolutepath);
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		boolean flag=true;
		while(flag)
		{
			try 
			{
				hp.logOutApp();
				flag=false;
			}
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
		
		wUtil.waitForAlertNswitchNAccept(driver);

		String USERNAME = fUtil.readDataFromPropertyFile("userEmail");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
	
		lp.loginAsHrHead(USERNAME, PASSWORD, lp.getDdEle_hrHead());
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		hp.navigateToAddEmployee(driver);
		emplp.searchEmployee(employeeId);
		String actualEmployeeFirstName = emplp.getEmpNameByUsingEmpID(driver, employeeId);
		
		Assert.assertEquals(actualEmployeeFirstName, employeeFirstNameToModify);
		
		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);

	}

}
