package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingProjectinRMG_Test 
	{
			public static void main(String[] args) throws SQLException
			{
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				driver.get("http://localhost:8084/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
				driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
				driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[.=\"Sign in\"]")).click();
				driver.findElement(By.xpath("//a[@href='/dashboard/projects']")).click();
				driver.findElement(By.xpath("//span[.=\"Create Project\"]")).click();
				driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_PROJ_01");
				driver.findElement(By.xpath("//input[@name=\"createdBy\"]")).sendKeys("Sindhu Ashok");
				WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
				Select s = new Select(ele);
				s.selectByIndex(2);			
				driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				driver.findElement(By.xpath("//span[.=\"Create Project\"]")).click();
				driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_PROJ_01");
				driver.findElement(By.xpath("//input[@name=\"createdBy\"]")).sendKeys("Sindhu Ashok");
				WebElement element = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
				Select sel = new Select(element);
				sel.selectByIndex(2);			
				driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				driver.findElement(By.xpath("//span[.=\"Create Project\"]")).click();
				driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_PROJ_02");
				driver.findElement(By.xpath("//input[@name=\"createdBy\"]")).sendKeys("DHANRAJ");
				WebElement ele1 = driver.findElement(By.xpath("(//select[@name='status'])[1]"));
				Select s1 = new Select(ele1);
				s1.selectByIndex(1);			
				driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				
				//Step 1 : Create object for implementation class
				
				Driver driver1 = new Driver();
				
				//Step 2 : Register Driver with JDBC
				DriverManager.registerDriver(driver1);
				
				//Establish the connection or set the connection		
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				
				//Step 4 : Create Statement 		
				Statement statement = connection.createStatement();
				
				//Step 5: Execute Query 
				ResultSet result = statement.executeQuery("select * from project;");
				
				//Step 6: Validate
				while(result.next())
				{
					System.out.println(result.getString(1));
				}
				
				//Step 7: close the connection
				connection.close();	
				
				
			}
	}