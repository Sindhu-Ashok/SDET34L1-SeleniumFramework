package com.vtiger.practiceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.vtiger.ElementRepository.Contactpage;
import com.vtiger.contacts.Test.CreateContactsTest;

public class CreateContactWithExcelTestNew extends BaseClass
{
	@Test
	
	public void createContactWithExcelTest()
	{
		String Firstname = ExcelUtilities.getDatafromExcel("Contact Name", 0, 1);
		String LastName = ExcelUtilities.getDatafromExcel("Contact Name", 1, 1);
		Contactpage contact = new Contactpage(driver);
		CreateContactsTest createcs = new CreateContactsTest();
		loginpage.loginToApp(userName, password);

		String Homepage = driver.getTitle();

		if(driver.getTitle().contains("Home"))
		{
			ExcelUtilities.createCell_Setcell("Contact Name", 6, 4, "Create Contact page is displayed");
			ExcelUtilities.createCell_Setcell("Contact Name", 6, 5, "TC pass");
		}

		//Contact page should be displayed 
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		if(driver.getTitle().contains("Contacts"))
		{
			ExcelUtilities.createCell_Setcell("Contact Name", 7, 4, "Create Contact page is displayed");
			ExcelUtilities.createCell_Setcell("Contact Name", 7, 5, "TC pass");
		}

		//FN LN should be accepted (Confirmation page should be displayed)
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(Firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		if(driver.getTitle().contains("Contacts"))
		{
			ExcelUtilities.createCell_Setcell("Contact Name", 8, 4, "Contacts should be added");
			ExcelUtilities.createCell_Setcell("Contact Name", 8, 5, "TC pass");		
		}

		WebElement Actual_FN = driver.findElement(By.xpath("//span[@id='dtlview_First Name']"));
		WebElement Actual_LN = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']"));

		if(Actual_LN.getText().equalsIgnoreCase(LastName))
		{
			javautil.printStatement("Contact created");
			javautil.printStatement("TC pass");
		}

		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webdriver_utilities.mouseHoveractions(mouseover, driver);

		//Should be logged out
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		String signout = driver.getTitle();
		{
			javautil.printStatement(signout);
		}

		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			ExcelUtilities.createCell_Setcell("Contact Name", 9, 4, "Contacts should be added");
			ExcelUtilities.createCell_Setcell("Contact Name", 9, 5, "TC pass");
		}	
	}		
}
