package com.vtiger.practiceTest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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

public class CreateOrganizationwithExcelTest

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
	   /*
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   driver.get(url);*/
	   
	   WebDriver_Utilities.browserSettings(10, driver);
	   WebDriver_Utilities.navigateToApp(url, driver);
	   
	 //Login to the appln
	 		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
	 		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	 		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	 		String login = driver.getTitle(); 
	 		{
	 			System.out.println(login);
	 		}
	 		if(driver.getTitle().contains("Home"))
	 		{
	 			/*wb.getSheet("Organization").getRow(4).createCell(6).setCellValue("Home page should be displayed");
	 			wb.getSheet("Organization").getRow(4).createCell(7).setCellValue("TC PASS");*/
	 			ExcelUtilities.createCell_Setcell("Organization", 4, 6, "Home page should be displayed");
	 			ExcelUtilities.createCell_Setcell("Organization", 4, 7, "Tc is pass");
	 		}

	 		//Click on Organization Major tab
	 		driver.findElement(By.xpath("//a[.='Organizations']")).click();
	 		String Major_tab = driver.getTitle();
	 		
	 		{
	 			System.out.println(Major_tab);
	 		}
	 		
	 		if(driver.getTitle().contains("Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
	 		{
	 			/*wb.getSheet("Organization").getRow(5).createCell(6).setCellValue("Organization page should be displayed");
	 			wb.getSheet("Organization").getRow(5).createCell(7).setCellValue("TC PASS");*/
	 			ExcelUtilities.createCell_Setcell("Organization", 5, 6, "Organization page should be dsiplayed");
	 			ExcelUtilities.createCell_Setcell("Organization", 5, 7, "Tc is pass");	
	 		}
	 		
	 		Thread.sleep(2000);
	 		
	 		//Click on Create Organization icon
	 		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	 		String orgn_icon = driver.getTitle();
	 		{
	 			System.out.println(orgn_icon);
	 		}
	 		
	 		if(driver.getTitle().contains("Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
	 		{
	 			/*wb.getSheet("Organization").getRow(6).createCell(6).setCellValue("Create Organization page should be displayed");
	 			wb.getSheet("Organization").getRow(6).createCell(7).setCellValue("TC PASS");*/
	 			ExcelUtilities.createCell_Setcell("Organization", 6, 6, "Create Organization page should be displayed");
	 			ExcelUtilities.createCell_Setcell("Organization", 6, 7, "Tc is pass");	
	 		}
	 		
	 		/*Random ran = new Random();
	 		ran.nextInt(100);*/
	 		
	 		//Enter organization name and save
	 		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organization_name+juit.getRandomNum(0));
	 		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	 		
	 		if(driver.getTitle().contains(" Commercial Open Source CRM"))
	 		{
	 			/*wb.getSheet("Organization").getRow(7).createCell(6).setCellValue("Organization name should be accepted and saved");
	 			wb.getSheet("Organization").getRow(7).createCell(7).setCellValue("TC PASS");*/
	 			ExcelUtilities.createCell_Setcell("Organization", 7, 6, "Organization name should be accepted and saved");
	 			ExcelUtilities.createCell_Setcell("Organization", 7, 7, "Tc is pass");	
	 		}
	 		
	 		//Validate the organization name
	 		WebElement orgname = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']"));
	 	
	 		if(orgname.getText().equalsIgnoreCase(organization_name))
	 		{
	 			System.out.println("Validated");
	 		}
	 		else
	 		{
	 			System.out.println("Not validated");
	 		}
	 		
	 		if(driver.getTitle().contains("DetailView&module"))
	 		{
	 			/*wb.getSheet("Organization").getRow(8).createCell(6).setCellValue("Validated successfully ");
	 			wb.getSheet("Organization").getRow(8).createCell(7).setCellValue("TC PASS");*/
	 			ExcelUtilities.createCell_Setcell("Organization", 8, 6, "Validated successfully");
	 			ExcelUtilities.createCell_Setcell("Organization", 8, 7, "Tc is pass");	
	 		}
	 		
	 		//Logout
	 		/*WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(mouseover).click().perform();*/
	 		
	 		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 		WebDriver_Utilities webDriver_Utilities = new WebDriver_Utilities();
			webDriver_Utilities.mouseHoveractions(mouseover, driver);
			
			String signout = driver.getTitle();
			{
				System.out.println(signout);
			}
			
			if(driver.getTitle().contains("Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
			{
				/*wb.getSheet("Organization").getRow(9).createCell(6).setCellValue("Login page should be displayed again");
				wb.getSheet("Organization").getRow(9).createCell(7).setCellValue("TC is pass");*/
				ExcelUtilities.createCell_Setcell("Organization", 9, 6, "Login page should be displayed again");
	 			ExcelUtilities.createCell_Setcell("Organization", 9, 7, "Tc pass");	
			}
	 		
	 	/*	//To write in excel
			FileOutputStream fos = new FileOutputStream("./src/test/resources/Worksheet.xlsx");
	 		wb.write(fos);
	 		wb.close();*/
		
			ExcelUtilities.saveExcelData(ConstantPath.EXCELPATH);
			
			ExcelUtilities.closeExcel();
			
	 		driver.quit();
		
	}
}
