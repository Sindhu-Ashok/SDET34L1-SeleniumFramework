package com.vtiger.practiceTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor 
{
	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		js.executeScript("window.location='http://localhost:8888'");
		driver.manage().window().maximize();
		js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.name("user_name")),"admin");
		js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.name("user_password")),"admin");
		js.executeScript("arguments[0].click()",driver.findElement(By.id("submitButton")));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//b[contains(.,'Upcoming Activities')]")));
		
		File src =ts.getScreenshotAs(OutputType.FILE);
		//String fileName = new javaScriptExecutor().getClass().getName();
		File dst = new File("./ScreenShot/+screenshot01.png");
		FileUtils.copyFile(src, dst);	
	}
}
