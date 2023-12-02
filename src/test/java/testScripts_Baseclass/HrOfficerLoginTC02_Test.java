package testScripts_Baseclass;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRM.GenericUtils.BaseClass;
import com.HRM.GenericUtils.ExcelUtils;
import com.HRM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.Home_Page;
import com.ObjectRepo.LoginPage;

//TESTED-now
@Listeners(com.HRM.GenericUtils.ListenersImplementation.class)
public class HrOfficerLoginTC02_Test extends BaseClass
{

	@Test
	public void  tc02() throws Throwable 
	{
		ExcelUtils eUtil=new ExcelUtils();
		WebDriverUtils wUtil=new WebDriverUtils();

		String hrOfficerUserEmail = eUtil.readDataFromExcel("TC_01", 7, 10);
		String hrOfficerPassword = eUtil.readDataFromExcel("TC_01", 8, 10);
		//String hrTypeOfficer = eUtil.readDataFromExcel("TC_01", 2, 13);

		wUtil.maximizeWindow(driver);
		wUtil.waitForpageLoad(driver, 20);
		wUtil.waitforPageLoadImplicitly(driver, 20);

		LoginPage lp = new LoginPage(driver);
		lp.loginAsHrOfficer(hrOfficerUserEmail, hrOfficerPassword, lp.getDdEle_hrOfficer());

		wUtil.waitForAlertNswitchNAccept(driver);

		String expurl = "http://rmgtestingserver/domain/HRM_System/Admin_Dashboard/Admin_Dashboard.php";
		wUtil.waitForUrlPresent(driver, 20, expurl);
		String actUrl = driver.getCurrentUrl();
		Reporter.log(actUrl, true);

		Assert.assertEquals(actUrl, expurl);

		Home_Page hp=new Home_Page(driver);
		hp.logOutApp();

		wUtil.waitForAlertNswitchNAccept(driver);
	}
}
