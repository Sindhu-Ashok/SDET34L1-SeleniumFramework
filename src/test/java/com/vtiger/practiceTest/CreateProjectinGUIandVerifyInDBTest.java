package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectinGUIandVerifyInDBTest
{
		public static void main(String[] args) throws Exception {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_P01");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("suklaa");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s = new Select(ele);
		s.selectByVisibleText("On Goging");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
				Driver driver1 = new Driver();				
				DriverManager.registerDriver(driver1);
			    Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				java.sql.Statement statement = connection1.createStatement();
				ResultSet result = statement.executeQuery("select * from project;");
				while(result.next())
				{
					System.out.println(result.getString(2));
				}
					connection1.close();
	}

}
