package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;

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

import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.FileUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductTest
{
	public static void main(String[] args) throws IOException {

		/*FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);

		String url = property.getProperty("url");
		String userName = property.getProperty("userName");
		String password = property.getProperty("password");*/
		
		FileUtilities.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
		String url = FileUtilities.fetchData_PF("url");
		String userName = FileUtilities.fetchData_PF("userName");
		String password = FileUtilities.fetchData_PF("password");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook w = WorkbookFactory.create(fis1);
		Sheet sheet = w.getSheet("Product Name");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	    WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).perform();
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}
}
