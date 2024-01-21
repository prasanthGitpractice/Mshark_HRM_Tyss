package com.HRM.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverUtils 
{
	
	/**
	 * This method is used to maximize window
	 * @author PRASANTH
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize window
	 * @author PRASANTH
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * This method is used to wait until pageload
	 * @param driver
	 * @param sec
	 */
	public void waitForpageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	public void waitforPageLoadImplicitly(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
	/**
	 * This method will wait for an element to be visible
	 * @param driver
	 * @param ele
	 * @param sec
	 */
	public void waitUntilEleToBeVisible(WebDriver driver, WebElement ele, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	/**
	 * This method will wait for an element to be Clickable
	 * @param driver
	 * @param ele
	 * @param sec
	 */
	public void waitUntilEleToBeClickable(WebDriver driver, WebElement ele, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForAlertPresent(WebDriver driver, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForUrlPresent(WebDriver driver, int sec, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	public void waitForAlertNswitchNAccept(WebDriver driver)
	{
		waitForAlertPresent(driver, 20);
		Reporter.log(driver.switchTo().alert().getText(), true);
		acceptAlert(driver);
	}
	
	public String getAlertMessage(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to select dropdown value by using index
	 * @author PRASANTH
	 * @param ele
	 * @param index
	 */
	public void dropDown(WebElement ele, int index)
	{
		Select s = new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is used to select dropdown value by using Value
	 * @author PRASANTH
	 * @param ele
	 * @param index
	 */
	public void dropDown(WebElement ele, String value)
	{
		Select s = new Select(ele);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used to select dropdown value by using visible text
	 * @author PRASANTH
	 * @param ele
	 * @param index
	 */
	public void dropDown(String text, WebElement ele)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	
	
	/**
	 * This method will perform drag and drop operation 
	 * @author PRASANTH
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will perform mouse hover action on a web element
	 * @author PRASANTH
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnWebElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	

	/**
	 * This method will perform mouse hover action on a web element to particular position
	 * @author PRASANTH
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnWebElement(WebDriver driver, WebElement element, int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element, x, y).perform();
	}
	
	/**
	 * This method will perform right click anywhere on the web page
	 * @author PRASANTH
	 * @param driver
	 */
	public void rightClickOnWebPage(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a particular web element
	 * @author PRASANTH
	 * @param driver
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click anywhere on the web page
	 * @author PRASANTH
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on a particular web element
	 * @author PRASANTH
	 * @param driver
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to click ENTER key using actions class
	 * @author PRASANTH
	 * @param driver
	 */
	public void keyPressEnter(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method is used to click ENTER key using Robot class
	 * @author PRASANTH
	 */
	public void keyPressEnter() throws Throwable
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to Release ENTER key using Robot class
	 * @author PRASANTH
	 * @author PRASANTH
	 */
	public void keyReleaseEnter() throws Throwable
	{
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to switch to frame using index
	 * @author PRASANTH
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch to frame using name Or ID
	 * @author PRASANTH
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method is used to switch to frame using webelement reference variable
	 * @author PRASANTH
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	/**
	 * This method will accept the alert popup
	 * @author PRASANTH
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @author PRASANTH
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the alert text and return it to caller
	 * @author PRASANTH
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle Frame using index
	 * @author PRASANTH
	 * @param driver
	 * @param index
	 */
	
	/**
	 * This method will scroll down for 500 units
	 * @author PRASANTH
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.ScrollBy(0,500);", "");
	}
	
	/**
	 * This method will scroll down until a particular web element
	 * @author PRASANTH
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		int y=element.getLocation().getY();
//		jse.executeScript("window.ScrollBy(0,"+y+");", element);
//		jse.executeScript("arguments[0].scrollIntoView();", element);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default page
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will help to switch the control from one window to another
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//Step 1: Capture all the window IDs
		Set<String> allWinIDs = driver.getWindowHandles();
		
		//Step 2: Navigate through each window 
		for(String id:allWinIDs)
		{
			//Step 3: Switch To each and capture the title
			String actTitle = driver.switchTo().window(id).getTitle();
			
			//Step 4: compare the title with required
			if(actTitle.contains(partialWindowTitle)) //true - 
			{
				break;
			}
		}
				
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dst);// here it is the need of commons.io jar file
		
		return dst.getAbsolutePath(); //used for extent reporting
	
	}
	
	
	
	
	
	
	
}
