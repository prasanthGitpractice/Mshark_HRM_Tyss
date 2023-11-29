package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.GenericUtils.WebDriverUtils;

public class LoginPage extends WebDriverUtils {
	// Declare Elements

	@FindBy(name = "hr_email")
	private WebElement hrEmail;

	@FindBy(name = "hr_password")
	private WebElement hrPassword;

	@FindBy(name = "hr_type")
	private WebElement hrType;
	
	@FindBy(xpath = "//option[@value='HR Head']")
	private WebElement ddEle_hrHead;

	@FindBy(xpath = "//option[@value='HR Officer']")
	private WebElement ddEle_hrOfficer;
	
	@FindBy(xpath = "//option[@value='HR Assistant']")
	private WebElement ddEle_hrAssistant;

	@FindBy(name = "login_hr")
	private WebElement signInBtn;
	
	

	// Initialize Elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Getters
	public WebElement getHrEmail() {
		return hrEmail;
	}

	public WebElement getHrPassword() {
		return hrPassword;
	}

	public WebElement getHrType() {
		 return hrType;
	}
	
	public String getDdEle_hrHead() {
		return ddEle_hrHead.getText();
	}

	public String getDdEle_hrOfficer() {
		return ddEle_hrOfficer.getText();
	}

	public String getDdEle_hrAssistant() {
		return ddEle_hrAssistant.getText();
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	
	
	// Business Libraries

	// select Hrtype in dropdown
	public void selectHrType(String value) {
		dropDown(hrType, value);
	}

	public void selectHrTypeUsingVisibleText (String visibleText) 
	{ 
		dropDown(visibleText, hrType);
	}

	public void selectHrType(int index) {
		dropDown(hrType, index);
	}

	// Login to application as HR Head Admin
	public void loginAsHrHead(String hr_Email, String hrPwd, String adminType) 
	{
		hrEmail.sendKeys(hr_Email);
		hrPassword.sendKeys(hrPwd);
		selectHrType("HR Head");
		signInBtn.click();
	}
	
	// Login to application as HR Officer Admin
	public void loginAsHrOfficer(String hr_Email, String hrPwd, String adminType) 
	{
		hrEmail.sendKeys(hr_Email);
		hrPassword.sendKeys(hrPwd);
		selectHrType("HR Officer");
		signInBtn.click();
	}
	
	// Login to application as HR Assistant Admin
	public void loginAsHrAssistant(String hr_Email, String hrPwd, String adminType) 
	{
		hrEmail.sendKeys(hr_Email);
		hrPassword.sendKeys(hrPwd);
		selectHrType(adminType);
		signInBtn.click();
	}

}
