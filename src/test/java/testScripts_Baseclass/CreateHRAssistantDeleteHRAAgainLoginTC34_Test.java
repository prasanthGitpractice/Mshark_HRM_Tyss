package testScripts_Baseclass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.ExcelUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.AddAdminPage;
import com.ObjectRepo.AdminPage;
import com.ObjectRepo.DeleteAdmin;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

// Tested-now
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class CreateHRAssistantDeleteHRAAgainLoginTC34_Test extends BaseClass
{
	@Test(groups = "smoke")
	public void TC_34() throws Throwable 	
	{
		WebDriverUtils wUtil=new WebDriverUtils();
		ExcelUtils eUtil=new ExcelUtils();
		
		wUtil.waitForpageLoad(driver, 20);
		wUtil.waitforPageLoadImplicitly(driver, 20);
		
		String USERNAME = futil.readDataFromPropertyFile("userEmail");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL = futil.readDataFromPropertyFile("url");
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginAsHrHead(USERNAME, PASSWORD, lp.getDdEle_hrHead());
		
		wUtil.waitForAlertNswitchNAccept(driver);
		
		Home_Page hp=new Home_Page(driver);
		hp.navigateToAddAdmin();
		AdminPage admp=new AdminPage(driver);
		admp.clickOnAddAdminBtn();

		eUtil.readMultipleDataFromExcel("TC_34", driver, 8, 0);
		
		String DDdata = ""+eUtil.readDataFromExcel("TC_34", 2, 4);
		AddAdminPage adAdmin=new AddAdminPage(driver);
		adAdmin.selectHrPositionByValue(DDdata, adAdmin.getPositionDropdown());
		adAdmin.getSaveButton().click();

		wUtil.waitForAlertNswitchNAccept(driver);

		String search = eUtil.readDataFromExcel("TC_34", 2, 6);
		admp.getSearchTextfield().sendKeys(search);

		hp.logOutApp();

		wUtil.waitForAlertNswitchNAccept(driver);

		String hrAssistantEmail = eUtil.readDataFromExcel("TC_34", 7, 1);
		String hrAssistantPassword = eUtil.readDataFromExcel("TC_34", 8, 1);
		String hrAssistant_ddValue = eUtil.readDataFromExcel("TC_34", 2, 4);

		//lp.loginAsHrAssistant(hrAssistantEmail, hrAssistantEmail, lp.getDdEle_hrAssistant());
		lp.loginAsHrAssistant(hrAssistantEmail, "hrAssistant8_52", hrAssistant_ddValue);

		wUtil.waitForAlertNswitchNAccept(driver);

		hp.logOutApp();

		wUtil.waitForAlertNswitchNAccept(driver);

		lp.loginAsHrHead(USERNAME, PASSWORD, lp.getDdEle_hrHead());

		wUtil.waitForAlertNswitchNAccept(driver);

		hp.navigateToAddAdmin();
		AdminPage admin=new AdminPage(driver);
		wutil.waitUntilEleToBeVisible(driver, admin.getSearchTextfield(), 20);
		admp.getSearchTextfield().sendKeys(search);

		String adminFirstName = eUtil.readDataFromExcel("TC_34", 3, 1);
		String hrId = eUtil.readDataFromExcel("TC_34", 2, 1);

		admp.clickOnDeleteAdminIcon(driver, adminFirstName, hrId);

		DeleteAdmin delAdm=new DeleteAdmin(driver);
		delAdm.deleteAdmin(driver);

		wUtil.waitForAlertNswitchNAccept(driver);

		admp.getSearchTextfield().sendKeys(search);

		hp.logOutApp();

		wUtil.waitForAlertNswitchNAccept(driver);

		lp.loginAsHrHead(hrAssistantEmail, hrAssistantPassword, lp.getDdEle_hrHead());
		
		wutil.getAlertMessage(driver);
		
		String expAlertMsg = "Invalid Email or Password,Please try again!";
		String ActpopupMsg = wUtil.getAlertMessage(driver);
		
		Assert.assertEquals(ActpopupMsg, expAlertMsg);

	}
}
