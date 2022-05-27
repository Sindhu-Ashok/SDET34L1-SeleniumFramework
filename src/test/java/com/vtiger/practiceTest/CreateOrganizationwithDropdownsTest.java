package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationwithDropdownsTest 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		/*FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);

		String url = property.getProperty("url");
		String userName = property.getProperty("userName");
		String password = property.getProperty("password");*/
		
		//Generic Creating the path and entering the keys
				FileUtilities.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
				String url = FileUtilities.fetchData_PF("url");
				String userName = FileUtilities.fetchData_PF("userName");
				String password = FileUtilities.fetchData_PF("password");
				
				Java_Utilities juit = new Java_Utilities();

		/*FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Organization");
		Row r = sheet.getRow(1);
		Cell c = r.getCell(1);
		String organization_name = c.getStringCellValue();*/
				
		ExcelUtilities.openExcel(ConstantPath.EXCELPATH);
		String organization_name = ExcelUtilities.getDatafromExcel("Organization", 1, 1);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/*driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);*/
		WebDriver_Utilities.navigateToApp(url, driver);
		WebDriver_Utilities.browserSettings(10, driver);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
 		driver.findElement(By.xpath("//a[.='Organizations']")).click();
 		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
 		
 		/*Random random = new Random();
 		random.nextInt(100);*/
 	
 		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organization_name+juit.getRandomNum(1000));
 		
 		WebElement industry_dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
 		
 		Select select = new Select(industry_dropdown);
 		select.selectByVisibleText("Education");
 		
 		WebElement type_dropdown = driver.findElement(By.xpath("//select[@name='accounttype']"));
 		
 		Select sel1 = new Select(type_dropdown);
 		sel1.selectByValue("Press");
 		
 		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
 		
 		Thread.sleep(2000);
 		
 		/*WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).click().perform();*/
 		
 		WebElement mouse = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 		WebDriver_Utilities webDriver_Utilities = new WebDriver_Utilities();
		webDriver_Utilities.mouseHoveractions(mouse, driver);
 		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
	}
}
