package com.rmgyantra.projectTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.SDET34L1_GenericUtilities.DataBase_Utilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectinGUIandVerifyInDBTest
{
		public static void main(String[] args) throws Exception
		{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriver_Utilities.navigateToApp("http://localhost:8084/", driver);
		WebDriver_Utilities.browserSettings(10, driver);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_P01");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("suklaa");
		
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		WebDriver_Utilities.dropDownHandle(ele,"On Goging");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		DataBase_Utilities.openDBConnection(ConstantPath.DATABASEURL+FileUtilities.fetchData_PF("DB_Username"),FileUtilities.fetchData_PF("DB_Password"), FileUtilities.fetchData_PF("DB_Name"));
		
		DataBase_Utilities.getDataFromDataBase("select * from project;", "2");
		
				/*Driver driver1 = new Driver();				
				DriverManager.registerDriver(driver1);
			    Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				java.sql.Statement statement = connection1.createStatement();
				ResultSet result = statement.executeQuery("select * from project;");
				while(result.next())
				{
					System.out.println(result.getString(2));
				}*/	
		
			DataBase_Utilities.closeDBConnection();
	}

}
