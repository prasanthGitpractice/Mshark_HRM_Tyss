package testScripts_Baseclass;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.ExcelUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.AddAdminPage;
import com.ObjectRepo.AddBranchesPage;
import com.ObjectRepo.AddCorporatePage;
import com.ObjectRepo.AddEmployeePage;
import com.ObjectRepo.AdminPage;
import com.ObjectRepo.BranchesPage;
import com.ObjectRepo.CorporateListPage;
import com.ObjectRepo.EmployeeListPage;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

// Tested-now
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class AddEmployeeTC01_Test extends BaseClass
{
	
	//Tested
	@Test(groups = "Regression")
	public void tC_01() throws Throwable
	{
		
		ExcelUtils eUtil= new ExcelUtils();
		WebDriverUtils wUtil = new WebDriverUtils();
		LoginPage lp=new LoginPage(driver);
		wUtil.waitForpageLoad(driver, 20);
		wUtil.waitforPageLoadImplicitly(driver, 20);
		
		String USERNAME = futil.readDataFromPropertyFile("userEmail");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL = futil.readDataFromPropertyFile("url");
		
		//Login as HrHead
		driver.get(URL);
		lp.loginAsHrHead(USERNAME, PASSWORD, lp.getDdEle_hrHead());
		
		wUtil.waitForAlertNswitchNAccept(driver);

		Home_Page hp=new Home_Page(driver);
		hp.navigateToAddCorporate();
		
		CorporateListPage corlp=new CorporateListPage(driver);
		
		wutil.waitUntilEleToBeClickable(driver, corlp.getAddCorporateBtnEle(), 20);
		corlp.getAddCorporateBtnEle().click();
		
		String corporateName = eUtil.readDataFromExcel("TC_01", 2, 4);

		AddCorporatePage adcorp=new AddCorporatePage(driver);		
		wutil.waitUntilEleToBeClickable(driver, adcorp.getCorpNameEle(), 20);
		adcorp.createNewCorporate(corporateName);
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		hp.navigateToAddBranches();
		String branchName = eUtil.readDataFromExcel("TC_01", 2, 7);
		BranchesPage brnch=new BranchesPage(driver);
		brnch.getAddBranchesButton().click();
		
		AddBranchesPage adbrnch=new AddBranchesPage(driver);
		adbrnch.addBranche(driver, branchName);

		wUtil.waitForAlertNswitchNAccept(driver);

		hp.navigateToAddAdmin();
		AdminPage admp=new AdminPage(driver);
		admp.clickOnAddAdminBtn();
		eUtil.readMultipleDataFromExcel("TC_01", driver,8, 9);

		String hrTypeAdmin = eUtil.readDataFromExcel("TC_01", 2, 13);
		//String hrTypeAdmin = sheet.getRow(2).getCell(13).getStringCellValue();
		AddAdminPage addAdm=new AddAdminPage(driver);
		addAdm.selectHrPositionByValue(hrTypeAdmin, addAdm.getPositionDropdown());
		addAdm.getSaveButton().click();

		wUtil.waitForAlertNswitchNAccept(driver);

		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		String hrOfficerUserEmail = eUtil.readDataFromExcel("TC_01", 7, 10);
		String hrOfficerPasswors = eUtil.readDataFromExcel("TC_01", 8, 10);

		lp.loginAsHrOfficer(hrOfficerUserEmail, hrOfficerPasswors, lp.getDdEle_hrOfficer());
		
		wUtil.waitForAlertNswitchNAccept(driver);

		wutil.waitUntilEleToBeClickable(driver, hp.getEmployeeEle(), 20);
		EmployeeListPage emplp=new EmployeeListPage(driver);
		
		try
		{
			hp.navigateToAddEmployee(driver);
			wutil.waitUntilEleToBeClickable(driver, emplp.getAddEmpBtn(), 120);
			emplp.getAddEmpBtn().click();
		}
		
		catch (Exception e) 
		{
			boolean flag=true;
			while(flag)
			{
				try
				{
					wutil.waitUntilEleToBeClickable(driver, emplp.getAddEmpBtn(), 100);
					emplp.getAddEmpBtn().click();
					flag=false;
				}
				catch (Exception e1) 
				{
					// TODO: handle exception
				}
			}
		}

		//Change Date Formats...during Script execution it is entering in different format..
		eUtil.readMultipleDataFromExcel("TC_01", driver,13, 15);

		String employeeDept = eUtil.readDataFromExcel("TC_01", 2, 4);		
		AddEmployeePage adEmp=new AddEmployeePage(driver);
		adEmp.setDeptDD(employeeDept);
		
		String employeeBranch = eUtil.readDataFromExcel("TC_01", 2, 7);
		adEmp.setBranchesDD(employeeBranch);
		

		File empFile = new File("C:\\Users\\PRASANTH\\Downloads\\CRM notes.pdf");
		String empFileAbsolutepath = empFile.getAbsolutePath();
		adEmp.uploadEmpFile201(empFileAbsolutepath);
		
		File profilePic = new File("C:\\Users\\PRASANTH\\Pictures\\Screenshots\\Screenshot 2023-11-10 155000.png");
		String profilePicAbsolutepath = profilePic.getAbsolutePath();
		adEmp.uploadEmpPic(profilePicAbsolutepath);
		
		wutil.waitUntilEleToBeClickable(driver, adEmp.getSaveBtn(), 20);
		adEmp.clickSaveBtn();	
		
		wUtil.waitForAlertNswitchNAccept(driver);

		String expEmployeeId = eUtil.readDataFromExcel("TC_01", 2, 16);
		String expEmpFname = eUtil.readDataFromExcel("TC_01", 3, 16);
		
		try
		{
			wUtil.waitUntilEleToBeVisible(driver, emplp.getSearchBoxEle(), 60);
			emplp.getSearchBoxEle().sendKeys(expEmployeeId);
		}
		catch (Exception e) 
		{
			boolean flag2=true;
			while(flag2)
			{
				try
				{
					wUtil.waitUntilEleToBeVisible(driver, emplp.getSearchBoxEle(), 60);
					emplp.getSearchBoxEle().sendKeys(expEmployeeId);
					flag2=false;
				}
				catch (Exception e1) 
				{
					// TODO: handle exception
				}
			}
		}
		
		String actEmpName = emplp.getEmpNameByUsingEmpID(driver, expEmployeeId);
		
		Assert.assertEquals(actEmpName, expEmpFname);
		
		hp.logOutApp();
		
		wUtil.waitForAlertNswitchNAccept(driver);

	}
}
