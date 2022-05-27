package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertingDatainDBTest 

{
	
	public static void main(String[] args) throws SQLException
	{
	
	Connection connection = null;
	{
		//1 Create Object
		Driver driver1 = new Driver();
		
		//2 Register to JDBC
		DriverManager.registerDriver(driver1);
		
		//3 Establish Connection
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		//4 Create Statement
		Statement statement = connection.createStatement();
		
		//Execute Query
		statement.executeUpdate("insert into project values('TY_Proj_1005','SINDHHHUU','28/07/2022','TYY07','ON going','12');");
		
		//Close the connection
		connection.close();
	
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.=\"Sign in\"]")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.=\"Create Project\"]")).click();
		String projectname = "SDET34L1";
		driver.findElement(By.name(projectname)).sendKeys("PROJECT");
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//
		driver.findElement(By.name("createdBy")).sendKeys("Dannyy");
		
		//DROPDOWN
		WebElement projectDropdown = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		Select select = new Select(projectDropdown);
		select.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value=\"Add Project\"]")).click();
	}
}
}
