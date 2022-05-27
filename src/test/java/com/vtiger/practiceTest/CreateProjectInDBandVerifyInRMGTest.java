package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectInDBandVerifyInRMGTest
{
	public static void main(String[] args) throws SQLException 
	{
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				java.sql.Statement statement = connection.createStatement();
				String project="manu";
				String projectid="TY_PROJ_001";
				String query= "insert into project(project_id,created_by,created_on,project_name,status,team_size) values('"+projectid+"','"+project+"','29/04/2022','TY_P02','On Going','3')";	
				 int result = statement.executeUpdate(query);
				 if(result==1)
				 {
					 System.out.println("user is created");
				 }
				 else
				 {
					 System.out.println("user is not created");
				 }
				connection.close();
				
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver1 = new FirefoxDriver();
				driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver1.get("http://localhost:8084/");
				driver1.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
				driver1.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
				driver1.findElement(By.xpath("//button[.='Sign in']")).click();
				driver1.findElement(By.xpath("//a[.='Projects']")).click();
				
				
				 List<WebElement> projectname = driver1.findElements(By.xpath("//table//tbody/tr/td[4]"));
				 for (WebElement project1 : projectname) {
					if (project1.getText().equalsIgnoreCase(project)) {
						System.out.println("project name is visible in GUI");
						System.out.println("test case pass");
					}
				}
				 driver1.quit();
	}

}


