package com.SDET34L1_GenericUtilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.ElementRepository.Homepage;
import com.vtiger.ElementRepository.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the common actions
 * @author sin42
 *Ttatatatata
 */
public class BaseClass {

	public String url;
	public String userName;
	public String password;
	public String browser;
	public long timeout1;
	public int RandomNumber;
	public WebDriver driver;
	public Loginpage loginpage;
	public Homepage homepage;
	public Java_Utilities javautil;
	public Actions act;
	public WebDriver_Utilities webdriver_utilities;

	/**
	 * This method is used to give the path for PropertyFile and ExcelFile 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforeSuiteTest() throws EncryptedDocumentException, IOException
	{
		FileUtilities.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
		ExcelUtilities.openExcel(ConstantPath.EXCELPATH);
	}

	/**
	 * This method contains all the data 
	 * @throws IOException
	 */
	@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeClassTest(/*String browser*/) throws IOException
	{
		javautil = new Java_Utilities();
		webdriver_utilities = new WebDriver_Utilities();
		url = FileUtilities.fetchData_PF("url");
		userName = FileUtilities.fetchData_PF("userName");
		password = FileUtilities.fetchData_PF("password");
		browser = FileUtilities.fetchData_PF("browser");
		String timeout = FileUtilities.fetchData_PF("timeout");
		timeout1 = javautil.stringtoLong(timeout);
		RandomNumber = javautil.getRandomNum(1000);

		switch (browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			javautil.printStatement("Specify browser key");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

		WebDriver_Utilities.browserSettings(timeout1, driver);
		webdriver_utilities.initializeActions(driver);
		webdriver_utilities.explicitlyWait(driver, timeout1);
	
		loginpage = new Loginpage(driver);
		homepage = new Homepage(driver);

		WebDriver_Utilities.navigateToApp(url, driver);
	}

	/**
	 * This method is used to navigate to the application
	 * 
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethodTest() 
	{
		loginpage.loginToApp(userName, password);
	}

	/**
	 * This method is used to logout from the application
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethodTest()
	{
		homepage.signout(driver, webdriver_utilities);
	}

	/**
	 * This method is used to Quit the browser
	 */
	@AfterClass(groups="baseclass") 
	public void afterClassTest() 
	{
		WebDriver_Utilities.quitBrowser(driver);
	}

	/**
	 * This method is used to close the excel
	 * @throws IOException
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuiteTest() throws IOException
	{
		ExcelUtilities.closeExcel();
	}

}
