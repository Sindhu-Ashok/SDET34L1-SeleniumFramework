package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
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

import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithExcelTest 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
				
				FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
				Properties property = new Properties();
				property.load(fis);
				
				String url = property.getProperty("url");
				String userName = property.getProperty("userName");
				String password = property.getProperty("password");
				String timeout = property.getProperty("timeout");
				
				long longtimeout = Long.parseLong(timeout);
				
				
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Contact Name");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		String Firstname = cell.getStringCellValue();
		
		Row r1 = sheet.getRow(1);
		Cell c1 = r1.getCell(1);
		String Lastname = c1.getStringCellValue();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Login to the appln
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		if(driver.getTitle().contains("Home"))
		{
			wb.getSheet("Contact Name").getRow(6).createCell(4).setCellValue("Home page is displayed");
			wb.getSheet("Contact Name").getRow(6).createCell(5).setCellValue("TC is pass");
		}
		
		//Contact page should be displayed 
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		if(driver.getTitle().contains("Contacts"))
		{
			/*wb.getSheet("Contact Name").getRow(7).createCell(4).setCellValue("Create Contact page is displayed");
			wb.getSheet("Contact Name").getRow(7).createCell(5).setCellValue("TC is pass");*/
			ExcelUtilities.createCell_Setcell("Contact Name", 7, 4, "Create Contact page is displayed");
			ExcelUtilities.createCell_Setcell("Contact Name", 7, 5, "TC pass");
		}
		
		//FN LN should be accepted (Confirmation page should be displayed)
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(Firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		if(driver.getTitle().contains("Contacts"))
		{
			/*wb.getSheet("Contact Name").getRow(8).createCell(4).setCellValue("Contacts should be added");
			wb.getSheet("Contact Name").getRow(8).createCell(5).setCellValue("TC is pass ");*/
			ExcelUtilities.createCell_Setcell("Contact Name", 8, 4, "Contacts should be added");
			ExcelUtilities.createCell_Setcell("Contact Name", 8, 5, "TC pass");		
		}
		
		WebElement Actual_FN = driver.findElement(By.xpath("//span[@id='dtlview_First Name']"));
		WebElement Actual_LN = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']"));
		
		if(Actual_LN.getText().equalsIgnoreCase(Lastname))
		{
			System.out.println("Contact created");
			System.out.println("TC pass");
		}
		
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).click().perform();
		
		//Should be logged out
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		String signout = driver.getTitle();
		{
			System.out.println(signout);
		}
		
		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			/*wb.getSheet("Contact Name").getRow(9).createCell(4).setCellValue("Login page should be displayed again");
			wb.getSheet("Contact Name").getRow(9).createCell(5).setCellValue("TC is pass");*/
			ExcelUtilities.createCell_Setcell("Contact Name", 9, 4, "Contacts should be added");
			ExcelUtilities.createCell_Setcell("Contact Name", 9, 5, "TC pass");
		}
		
		/*FileOutputStream fos = new FileOutputStream("./src/test/resources/Worksheet.xlsx");
		wb.write(fos);
		wb.close();*/
		
		ExcelUtilities.saveExcelData(ConstantPath.EXCELPATH);
		WebDriver_Utilities.quitBrowser(driver);
		ExcelUtilities.closeExcel();		
	}	
	
	
}
