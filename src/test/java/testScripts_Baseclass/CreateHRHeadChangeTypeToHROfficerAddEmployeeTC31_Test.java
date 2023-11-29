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
import com.ObjectRepo.AddAdminPage;
import com.ObjectRepo.AddEmployeePage;
import com.ObjectRepo.AdminPage;
import com.ObjectRepo.EditEmployeePage;
import com.ObjectRepo.EmployeeListPage;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

// Tested
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class CreateHRHeadChangeTypeToHROfficerAddEmployeeTC31_Test extends BaseClass
{
	@Test
	public void tc31() throws Throwable 
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
		hp.navigateToAddAdmin();
		
		AdminPage admp=new AdminPage(driver);
		admp.getAddAdminButton().click();
		
		// Implement through Business Logic
		eUtil.readMultipleDataFromExcel("TC_31", driver, 8, 0);
		
		AddAdminPage addAdm=new AddAdminPage(driver);
		String hrType = eutil.readDataFromExcel("TC_31", 2, 4);
		addAdm.selectHrPositionByValue(hrType, addAdm.getPositionDropdown());
		addAdm.getSaveButton().click();
		
		wUtil.waitForAlertNswitchNAccept(driver);

		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);

		String HRHUsername = eUtil.readDataFromExcel("TC_31", 7, 1);
		String HRHPassword = eUtil.readDataFromExcel("TC_31", 8, 1);
		
		lp.loginAsHrHead(HRHUsername, HRHPassword, lp.getDdEle_hrHead());

		wUtil.waitForAlertNswitchNAccept(driver);
		
		hp.navigateToAddEmployee(driver);
		EmployeeListPage emplp=new EmployeeListPage(driver);
		emplp.getAddEmpBtn().click();

		String department = eUtil.readDataFromExcel("TC_31", 2, 9);
		String branch = eUtil.readDataFromExcel("TC_31", 2, 11);
		
		AddEmployeePage addemp=new AddEmployeePage(driver);
		WebElement dept_DD = addemp.getDeptDD();
		WebElement branch_DD = addemp.getBranchesDD();

		File empFile = new File("C:\\Users\\PRASANTH\\Downloads\\CRM notes.pdf");
		String empFileAbsolutepath = empFile.getAbsolutePath();
		File profilePic = new File("C:\\Users\\PRASANTH\\Pictures\\Screenshots\\Screenshot 2023-11-10 155000.png");
		String profilePicAbsolutepath = profilePic.getAbsolutePath();
		
		eUtil.readMultipleDataFromExcel("TC_31", driver, 13, 6);
		wUtil.dropDown(dept_DD, department);
		wUtil.dropDown(branch_DD, branch);
		addemp.uploadEmpFile201(empFileAbsolutepath);
		addemp.uploadEmpPic(profilePicAbsolutepath);
		addemp.clickSaveBtn();

		wUtil.waitForAlertNswitchNAccept(driver);
		
		hp.logOutApp();

		wUtil.waitForAlertNswitchNAccept(driver);

		String OfficerUn = eUtil.readDataFromExcel("TC_31", 2, 14);
		String OfficerPwd = eUtil.readDataFromExcel("TC_31", 3, 14);
		
		lp.loginAsHrOfficer(OfficerUn, OfficerPwd, lp.getDdEle_hrOfficer());

		wUtil.waitForAlertNswitchNAccept(driver);
		
		try
		{
			hp.navigateToAddEmployee(driver);
		}
		catch (Exception e) 
		{
			
		}
		
		String empId = eUtil.readDataFromExcel("TC_31", 2, 7);
		
		emplp.searchEmployee(empId);
		
		emplp.editEmployee(driver, empId);
		
		EditEmployeePage edtemp=new EditEmployeePage(driver);
		edtemp.getEmpContactEle().clear();

		String updatedContactNo = eUtil.readDataFromExcel("TC_31", 10, 1);
		edtemp.getEmpContactEle().sendKeys(updatedContactNo);

		String employeeId = eUtil.readDataFromExcel("TC_31", 2, 7);
		
		File empFile2 = new File("C:\\Users\\PRASANTH\\Downloads\\CRM notes.pdf");
		String empFileAbsolutepath2 = empFile2.getAbsolutePath();
		File profilePic2 = new File("C:\\Users\\PRASANTH\\Pictures\\Screenshots\\Screenshot 2023-11-10 155000.png");
		String profilePicAbsolutepath2 = profilePic2.getAbsolutePath();
		
		EditEmployeePage edtemPage=new EditEmployeePage(driver);
		edtemPage.updateEmployee(driver, updatedContactNo, employeeId, empFileAbsolutepath2, profilePicAbsolutepath2);
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		String actualContactNo = emplp.getActualContactNumberOfEmp(driver, employeeId);
		
		Assert.assertEquals(actualContactNo, updatedContactNo);
		
		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);

	}

}
