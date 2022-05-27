package com.SDET34L1_GenericUtilities;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to Maintain all the WebDriver Common actions 
 * @author sin42
 *
 */
public class WebDriver_Utilities
{
	/**
	 * This method is used to navigate to application
	 * @param url
	 * @param driver
	 */
	//Global variable
	static Select select;
	Actions act;
	static WebDriverWait wait;
	
	public static void navigateToApp(String url, WebDriver driver)
	{
		driver.get(url);
	}	
	/**
	 * This method is used to maximize and implicitly wait
	 * @param longTimeOut
	 * @param driver
	 */
	public static void browserSettings(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillPageloads(longTimeOut, driver);
	}
	
	/**
	 * To maximize browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Implicitly wait 
	 * @param longTimeOut
	 * @param driver
	 */
	public static void waitTillPageloads(long longTimeOut, WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to initialize the Action class
	 * @param driver
	 */
	public void initializeActions(WebDriver driver)
	{
		act = new Actions(driver);
	}
	
	/**
	 * This method is used to o MousehoverAction
	 * @param element
	 * @param driver
	 */
	public void mouseHoveractions(WebElement element,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * This method is used to Double click on the element
	 * @param element
	 */
	public void doubleClick(WebElement element)
	{
		act.moveToElement(element).click().perform();
	}
	/**
	 * This method is used to Right Click
	 */
	public void rightClick()
	{
		act.contextClick().perform();
	}
	/**
	 * This method is used to Right click on the element
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		act.contextClick(element).perform();
	}
	
	/**
	 * This method is used to Quit the browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	/**
	 * This method is used for Explicitly wait
	 * @param driver
	 * @param timeOut
	 * @param wait
	 */
	public  void explicitlyWait(WebDriver driver, long timeout)
	{
		 wait = new WebDriverWait(driver,timeout);
	}
	
	/**
	 *  This method is used to wait the control till the particular element is Clickable
	 * @param element
	 */
	public void waitUntilElementClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilElementVisibility(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to switchto browser
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver, String partialText)
	{
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
		 driver.switchTo().window(id);
		if(driver.getTitle().contains(partialText))
		 {
			 break;
		 }
	}		
}
		
	/**
	 * This method is used to Intialize the Select class
	 * @param element
	 */
	public static void initializeSelect(WebElement element)
	{
		select = new Select(element);
	}
	
	/**
	 * This method is used to handle dropdown by VisibleText
	 * @param element
	 * @param visibletext
	 */
	public static void dropDownHandle(WebElement element, String visibletext)
		{
			Select select = new Select(element); 		
			select.selectByVisibleText(visibletext);
			
		}
	/*
	 * This method is used to handle Drop down by Index
	 * @param element
	 * @param index
	 */
	public static void dropDownHandle(WebElement element, int index)
	{
	 		select.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle Drop down by Value
	 * @param value
	 * @param element
	 */
	public static void dropDownHandle(String value,WebElement element)
	{
	 	Select select = new Select(element);	
		select.selectByValue(value);
	}
	/**
	 * This method is used to switch frames by Index
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver, int index) 
	{
		driver.switchTo().frame(index);
	}
		
	/**
	 * This method is used to switch frames by Index
	 * @param driver
	 * @param nameorID
	 */
	public static void switchToFrame(WebDriver driver, String nameorID) 
	{
		driver.switchTo().frame(nameorID);
	}

	/**
	 * This method is used to switch to frame by elements
	 * @param driver
	 * @param element
	 */
	public static void switchToFrame(WebDriver driver, WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to switch to the main frame
	 * @param driver
	 */
	public static void switchBackToHome(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to handle Confirm Alert Notifications
	 * @param driver
	 */
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to dismiss the alert notification
	 * @param driver
	 */
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	} 
	
	/**
	 * This method is used to fetch the text of an Alert Notification
	 * @param driver
	 */
	public static String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to send the data
	 * @param driver
	 */
	public static void alertSendData(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys("data");
	}
	
}
	

