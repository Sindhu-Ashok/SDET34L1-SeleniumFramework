package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganizationTest
{

	public static void main(String[] args) throws IOException, Throwable 
	
	{		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String userName = property.getProperty("userName");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");
		
		long longtimeout = Long.parseLong(timeout);

		//TESTDATA - EXCEL
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook work = WorkbookFactory.create(fis1);
		Sheet sheet = work.getSheet("Organization");
		Row r = sheet.getRow(1);
		Cell c = r.getCell(1);
		String data = c.getStringCellValue();
		
		Sheet s1 = work.getSheet("Contact Name");
		Row r1 = s1.getRow(0);
		Cell c1 = r1.getCell(1);
		String firstname = c1.getStringCellValue();
		
		Sheet s2 = work.getSheet("Contact Name");
		Row r2 = s2.getRow(1);
		Cell c2 = r2.getCell(1);
		String lastname = c2.getStringCellValue();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		Random random = new Random(); 
	    int ran = random.nextInt(1000);
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data+ran);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(2000);
		
		WebElement ss = driver.findElement(By.xpath("//a [@href='index.php?module=Contacts&action=index']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(ss).click().perform();
	
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);				
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		/*String parent_browser = driver.getWindowHandle();
		System.out.println(parent_browser);
		
		Set<String> child_and_parent = driver.getWindowHandles();
		System.out.println(child_and_parent);
		child_and_parent.remove(parent_browser);
		for(String only_child:child_and_parent)
		{
			driver.switchTo().window(only_child);
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("TYSS935");
	        driver.findElement(By.xpath("//input[@name='search']")).click();
	        driver.findElement(By.id("1")).click();
		}
       driver.switchTo().window(parent_browser);*/
		
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
		 driver.switchTo().window(id);
		 if(driver.getTitle().contains("Accounts&Action"))
		 {
			 break;
		 }

		}
       
       driver.findElement(By.xpath("//input[@accesskey='S']")).click();
        
       
      WebElement mouse = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       Actions act1 = new Actions(driver);
       act1.moveToElement(mouse).click().perform();
            
       driver.findElement(By.xpath("//a[.='Sign Out']")).click();  
 
	}

}
