package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignNamewithProductTest
{
	//public static void main(String[] args) throws IOException
	
	@Test
	public void createCampwithProductTest() throws IOException
	{
		
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String userName = property.getProperty("userName");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook w = WorkbookFactory.create(fis1);
		Sheet sheet = w.getSheet("Campaign");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();	
		
		Sheet s1 = w.getSheet("Product Name");
		Row r = s1.getRow(0);
		Cell c = r.getCell(0);
		String productname = c.getStringCellValue();
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//img[@style='padding-left:5px']")).click();
		
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(data);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		   WebElement mouse = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	       Actions act1 = new Actions(driver);
	       act1.moveToElement(mouse).click().perform();
	       
	       driver.findElement(By.xpath("//a[.='Sign Out']")).click();  
	}
	}
}

