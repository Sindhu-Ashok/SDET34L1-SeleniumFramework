package com.vtiger.practiceTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingDBandFetchinginVtigerTest 
{

	public static void main(String[] args)
	{
		
	String url=null,password=null,username=null,timeout=null;
	
	{
/*		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from vtiger;");
		while(result.next())
		{
			 url = result.getString("URL");
			 password = result.getString("Password");
			 username = result.getString("Username");		
	//		 timeout = result.getString("Timeout");*/
		}

		long longTimeOut= Long.parseLong(timeout);
		WebDriver driver=null;
	
		WebDriverManager.chromedriver().setup();
		//WebDriver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	}
}

