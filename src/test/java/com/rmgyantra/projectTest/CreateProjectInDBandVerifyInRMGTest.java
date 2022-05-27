package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.DataBase_Utilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectInDBandVerifyInRMGTest
{
	public static void main(String[] args) throws SQLException, IOException 
	{
				Java_Utilities juit = new Java_Utilities();
				FileUtilities.openPropertyFile(ConstantPath.RMGYANTRA_PROPERTYFILEPATH);
				DataBase_Utilities.openDBConnection(ConstantPath.DATABASEURL+FileUtilities.fetchData_PF("DB_Name"),FileUtilities.fetchData_PF("DB_Username"),FileUtilities.fetchData_PF("DB_Password"));
				juit.getRandomNum(1000);
				String project="SindhuAshok";
				String projectid="TY_PROJ_001";
				int ran = juit.getRandomNum(1000);
				 String query= "insert into project(project_id,created_by,created_on,project_name,status,team_size) values('TY_PROJ_001'+ran,'Sindhuuu','29/04/2022','TY_P0222','On Going','3')";	
				 
				/* int result = statement.executeUpdate(query);
				 if(result==1)
				 {
					 System.out.println("user is created");
				 }
				 else
				 {
					 System.out.println("user is not created");
				 }*/
				 
				 DataBase_Utilities.setDataInDataBase(query);
				 DataBase_Utilities.closeDBConnection();
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				WebDriver_Utilities.browserSettings(10, driver);
				WebDriver_Utilities.navigateToApp("http://localhost:8084/",driver);
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[.='Sign in']")).click();
				driver.findElement(By.xpath("//a[.='Projects']")).click();
				
				List<WebElement> projectname = driver.findElements(By.xpath("//table//tbody/tr/td[4]"));
				 for (WebElement project1 : projectname) {
					if (project1.getText().equalsIgnoreCase(project)) {
						System.out.println("project name is visible in GUI");
						System.out.println("test case pass");
					}
				}
				 driver.quit();
	}

}


