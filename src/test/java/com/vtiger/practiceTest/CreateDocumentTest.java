package com.vtiger.practiceTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest

{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		FileUtilities.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
		String url = FileUtilities.fetchData_PF("url");
		String userName = FileUtilities.fetchData_PF("userName");
		String password = FileUtilities.fetchData_PF("password");
		
		Java_Utilities juit = new Java_Utilities();
		
		ExcelUtilities.openExcel(ConstantPath.EXCELPATH);
		/*ExcelUtilities.getDatafromExcel("Documents", 0, 1);*/
		String title = ExcelUtilities.getDatafromExcel("Documents", 1, 0);
		
		
		/*FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Documents");
		Row r = sheet.getRow(0);
		Cell c = r.getCell(1);
		String title = c.getStringCellValue();*/
		
		/*String documenttitle = wb.getSheet("Documents").getRow(1).getCell(0).getStringCellValue();
		String documentPath = wb.getSheet("Documents").getRow(1).getCell(1).getStringCellValue();
		String documentdescription = wb.getSheet("Documents").getRow(1).getCell(2).getStringCellValue();*/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/*driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*WebDriverWait wait = new WebDriverWait(driver, null, null, 0, 0);*/
		
		//URL, Maximize, Implicitlywait
		WebDriver_Utilities.navigateToApp(url, driver);
		WebDriver_Utilities.browserSettings(10, driver);
		
		/*driver.get(url);*/
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
 		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
 		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
 		
 		//Documents
 		driver.findElement(By.xpath("//a[@href='index.php?module=Documents&action=index']")).click();
 		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
 		
 	
 		/*Random random = new Random();
 		int ran = random.nextInt(200);*/
 		                                                                             
 		driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(title+juit.getRandomNum(1000));
 		
 		driver.switchTo().frame(0);
 		WebElement data = driver.findElement(By.xpath("//html[@dir='ltr']"));
 		data.sendKeys("Paaraaaa-paaa-paaaaahaaaa");
 		data.sendKeys(Keys.CONTROL+"abi");
 		driver.switchTo().parentFrame();
 		
 		//File uploading
 		driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys("C:\\Users\\sin42\\Desktop\\Sample.docx");
 		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
 		
 		Thread.sleep(2000);
 		
 		/*//Mouseover Action
 		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 		Actions act = new Actions(driver);
 		act.moveToElement(mouseover).click().perform();*/
 		
 		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriver_Utilities webDriver_Utilities = new WebDriver_Utilities();
		webDriver_Utilities.mouseHoveractions(mouseover, driver);
 		
 		driver.findElement(By.xpath("//a[.='Sign Out']")).click();		
	}
}
