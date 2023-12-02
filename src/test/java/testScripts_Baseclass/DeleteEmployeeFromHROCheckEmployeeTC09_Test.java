package testScripts_Baseclass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.ExcelUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.AddEmployeePage;
import com.ObjectRepo.EmployeeListPage;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

//tested-now
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class DeleteEmployeeFromHROCheckEmployeeTC09_Test extends BaseClass
{

	@Test
	public void tc09() throws Throwable
	{
		ExcelUtils eUtil = new ExcelUtils();
		WebDriverUtils wUtil = new WebDriverUtils();

		wUtil.waitForpageLoad(driver, 20);
		wUtil.waitforPageLoadImplicitly(driver, 120);

		String hrOfficerUserEmail = eUtil.readDataFromExcel("TC_09", 3, 1);
		String hrOfficerPasswors = eUtil.readDataFromExcel("TC_09", 4, 1);

		LoginPage lp = new LoginPage(driver);

		lp.loginAsHrOfficer(hrOfficerUserEmail, hrOfficerPasswors, lp.getDdEle_hrOfficer());

		wUtil.waitForAlertNswitchNAccept(driver);

		Home_Page hp = new Home_Page(driver);
		int initialEmployeeCount = hp.getDBEmployeeCount();
		System.out.println("Total count of employees before deletion is : " + initialEmployeeCount);
	
		String employeeId = eUtil.readDataFromExcel("TC_09", 2, 4);
		AddEmployeePage ademp = new AddEmployeePage(driver);
		EmployeeListPage emplp=new EmployeeListPage(driver);
		
		try 
		{
			hp.navigateToAddEmployee(driver);
			emplp.getSearchBoxEle().sendKeys(employeeId);
		}
		catch (Exception e) 
		{
			boolean flag=true;
			while(flag)
			{
				try
				{
					wutil.waitUntilEleToBeVisible(driver, emplp.getSearchBoxEle(), 100);
					emplp.getSearchBoxEle().sendKeys(employeeId);
					flag=false;
				}
				catch (Exception e1) 
				{

				}
				
			}
		}
		
		ademp.deleteEmployee(driver, employeeId);
		
		wUtil.waitForAlertNswitchNAccept(driver);
		boolean flag2=true;
		while(flag2)
		{
			try
			{
				wutil.waitUntilEleToBeClickable(driver, hp.getDashBoardEle(), 100);
				hp.getDashBoardEle().click();
				flag2=false;
			}
			catch (Exception e) 
			{
			
			}
		}

		int currentEmployeeCount = hp.getDBEmployeeCount();
		
		Assert.assertEquals(currentEmployeeCount, initialEmployeeCount - 1);
		
		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
	}
}
