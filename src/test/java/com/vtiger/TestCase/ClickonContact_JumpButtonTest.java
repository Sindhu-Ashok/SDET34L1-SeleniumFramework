package com.vtiger.TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;
import com.vtiger.ElementRepository.Contactpage;
import com.vtiger.ElementRepository.CreateContactPage;
import com.vtiger.ElementRepository.Homepage;
import com.vtiger.ElementRepository.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickonContact_JumpButtonTest extends BaseClass
{
	@Test
	
	public static void main(String[] args) throws IOException 
	{
		FileUtilities.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
		Java_Utilities juit = new Java_Utilities();
		
		String url = FileUtilities.fetchData_PF("url");
		String userName = FileUtilities.fetchData_PF("userName");
		String password = FileUtilities.fetchData_PF("password");
		String timeout = FileUtilities.fetchData_PF("timeout");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Loginpage login = new Loginpage(driver);
		Homepage home = new Homepage(driver);
		Contactpage contact = new Contactpage(driver);
		CreateContactPage createcp = new CreateContactPage(driver);
		
		
		WebDriver_Utilities.navigateToApp(url, driver);
		WebDriver_Utilities.browserSettings(juit.stringtoLong(timeout), driver);
		
		login.loginToApp(userName, password);
		home.contactClick();
		
		driver.findElement(By.xpath("(//a[@href='index.php?module=Contacts&parenttab=Marketing&action=DetailView&record=11'])[2]")).click();
		
		driver.findElement(By.xpath("//img[@id='jumpBtnIdTop']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=DetailView&parenttab=Marketing&record=19&start=1']")).click();
		
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriver_Utilities webDriver_Utilities2 = new WebDriver_Utilities();
		webDriver_Utilities2.mouseHoveractions(mouseover, driver);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click(); 
		
	}	

}
