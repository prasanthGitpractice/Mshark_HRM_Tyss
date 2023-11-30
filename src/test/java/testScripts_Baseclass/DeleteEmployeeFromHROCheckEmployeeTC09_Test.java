package testScripts_Baseclass;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.ExcelUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.AddEmployeePage;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

//tested
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class DeleteEmployeeFromHROCheckEmployeeTC09_Test extends BaseClass
{

	@Test
	public void tc09() throws Throwable
	{
		ExcelUtils eUtil = new ExcelUtils();
		WebDriverUtils wUtil = new WebDriverUtils();

		wUtil.waitForpageLoad(driver, 20);
		wUtil.waitforPageLoadImplicitly(driver, 20);

		String hrOfficerUserEmail = eUtil.readDataFromExcel("TC_09", 3, 1);
		String hrOfficerPasswors = eUtil.readDataFromExcel("TC_09", 4, 1);

		driver.findElement(By.name("hr_email")).sendKeys(hrOfficerUserEmail);
		driver.findElement(By.name("hr_password")).sendKeys(hrOfficerPasswors);

		LoginPage lp = new LoginPage(driver);

		lp.loginAsHrOfficer(hrOfficerUserEmail, hrOfficerPasswors, lp.getDdEle_hrOfficer());

		wUtil.waitForAlertNswitchNAccept(driver);

		Home_Page hp = new Home_Page(driver);
		int initialEmployeeCount = hp.getDBEmployeeCount();
		System.out.println("Total count of employees before deletion is : " + initialEmployeeCount);

		hp.navigateToAddEmployee(driver);
		
		String employeeId = eUtil.readDataFromExcel("TC_09", 2, 4);

		AddEmployeePage ademp = new AddEmployeePage(driver);
		ademp.searchEmployee(driver, employeeId);
		
		ademp.deleteEmployee(driver, employeeId);
		
		wUtil.waitForAlertNswitchNAccept(driver);

		wUtil.acceptAlert(driver);

		hp.clcikOnDashBoard();

		int currentEmployeeCount = hp.getDBEmployeeCount();
		
		Assert.assertEquals(currentEmployeeCount, initialEmployeeCount - 1);
		
		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
	}
}
