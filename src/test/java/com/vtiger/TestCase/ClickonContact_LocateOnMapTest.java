package com.vtiger.TestCase;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickonContact_LocateOnMapTest {
	
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
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("SindhuAshokkkkkkk");
		driver.findElement(By.xpath("//textarea[@name='mailingstreet']")).sendKeys("A136 Sector 2 HMT Colony Jahalli");
		driver.findElement(By.xpath("//input[@name='mailingcity']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='mailingstate']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@id='mailingzip']")).sendKeys("560013");
		driver.findElement(By.xpath("//input[@id='mailingcountry']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		WebElement mouseover = driver.findElement(By.xpath("//input[@value='Locate Map']"));
		WebDriver_Utilities webDriver_Utilities = new WebDriver_Utilities();
		webDriver_Utilities.mouseHoveractions(mouseover, driver);
		driver.findElement(By.xpath("//a[.='Primary Address:']")).click();
		
		String parent_browser = driver.getWindowHandle();
		System.out.println(parent_browser);
		
		Set<String> child_and_parent = driver.getWindowHandles();
		System.out.println(child_and_parent);
		child_and_parent.remove(parent_browser);
		for(String only_child:child_and_parent)
		{
			driver.switchTo().window(only_child);  
			driver.findElement(By.xpath("//button[@id=\"searchbox-searchbutton\"]")).click();
			driver.manage().window().maximize();
		}
		Thread.sleep(4000);
		
		driver.switchTo().window(parent_browser);
		WebElement mouseover1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriver_Utilities webDriver_Utilities2 = new WebDriver_Utilities();
		webDriver_Utilities2.mouseHoveractions(mouseover1, driver);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click(); 
	}

}
