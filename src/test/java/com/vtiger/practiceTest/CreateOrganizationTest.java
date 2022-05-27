package com.vtiger.practiceTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest 

{
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/*driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(" Testyantraaaaaa");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(ele.contains("Test"))
		{
			System.out.println("Validated");
		}
		else 
		{
			System.out.println("Not validated");
		}
		
		/*WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).perform();*/
		
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriver_Utilities webDriver_Utilities = new WebDriver_Utilities();
		webDriver_Utilities.mouseHoveractions(mouseover, driver);
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
		
	}
}
