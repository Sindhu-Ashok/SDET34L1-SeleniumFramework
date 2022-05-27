package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingDatafromPF_Test

{
	public static void main(String[] args) throws IOException 
	{
		//Step 1: Converting property file to Java readable object
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//Step 2: Create object for Property file
		
		Properties property = new Properties();
		
		//Step 3: Load all the keys
		
		property.load(fis);
		
		//Step 4: Fetch the data by using KEY
		
				String url = property.getProperty("url");
				String userName = property.getProperty("userName");
				String password = property.getProperty("password");
				String timeout = property.getProperty("timeout");
				String browser = property.getProperty("browser");
				String lastname = property.getProperty("lastname");
				
			 long longtime = Long.parseLong(timeout);
			 WebDriver driver = null;
			 
			 switch (browser)
			 {
			 	case "chrome":
			 		WebDriverManager.chromedriver().setup();
			 		driver = new ChromeDriver();			 		
			 		break;
			 		
			 	case "firefox":
			 		WebDriverManager.firefoxdriver().setup();
			 		driver = new FirefoxDriver();
			 		break;
			 }
			 
			 		driver.get(url);
			 		driver.manage().window().maximize();
			 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 		
			 		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
					driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
					driver.findElement(By.xpath("//input[@id='submitButton']")).click();
					driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
					driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
					driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
					driver.findElement(By.xpath("//input[@type='submit']")).click();
					WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					Actions act = new Actions(driver);
					act.moveToElement(mouseover).perform();				
					driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			 
				
	}
}
	

