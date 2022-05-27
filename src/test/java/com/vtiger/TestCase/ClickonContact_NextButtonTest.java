package com.vtiger.TestCase;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickonContact_NextButtonTest
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileUtilities.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
		Java_Utilities juit = new Java_Utilities();
		
		String url = FileUtilities.fetchData_PF("url");
		String userName = FileUtilities.fetchData_PF("userName");
		String password = FileUtilities.fetchData_PF("password");
		String timeout = FileUtilities.fetchData_PF("timeout");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriver_Utilities.navigateToApp(url, driver);
		WebDriver_Utilities.browserSettings(juit.stringtoLong(timeout), driver);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		
		driver.findElement(By.xpath("(//a[@href='index.php?module=Contacts&parenttab=Marketing&action=DetailView&record=11'])[2]")).click();
		driver.findElement(By.xpath("(//img[@title=\"Next\"])[1]")).click();
		
		Thread.sleep(2000);
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriver_Utilities webDriver_Utilities = new WebDriver_Utilities();
		webDriver_Utilities.mouseHoveractions(mouseover, driver);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();  
		
	}
}
