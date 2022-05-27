package com.vtiger.practiceTest;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignNameTest 
{
	//public static void main(String[] args) throws IOException 
	@Test
	public void createCampaignTest() throws IOException
	{
	
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);
		
		String CampaignName = property.getProperty("CampaignName");
		String url = property.getProperty("url");
		String userName = property.getProperty("userName");
		String password = property.getProperty("password");
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		
 		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(CampaignName);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		 WebElement m2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act1 = new Actions(driver);
		 act1.moveToElement(m2).perform();
		 
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();		
		
		}
	}
}
