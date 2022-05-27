package com.vtiger.contacts.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;
import com.vtiger.ElementRepository.Contactpage;
import com.vtiger.ElementRepository.CreateContactPage;
import com.vtiger.ElementRepository.CreateOrganizationPage;
import com.vtiger.ElementRepository.Homepage;
import com.vtiger.ElementRepository.Loginpage;
import com.vtiger.ElementRepository.Organizationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganizationTest extends BaseClass
{
	String organization_name;
	String firstname;
	String lastname;
	Organizationpage organizationpage;
	Contactpage contactpage;
	CreateContactPage createcontactpage;
	CreateOrganizationPage createorganizationpage;
	
	@Test(groups = "sanity")
	public void createContactwithOrganizationTest() throws InterruptedException
	{
		organization_name = ExcelUtilities.getDatafromExcel("Organization", 1, 1);
		firstname = ExcelUtilities.getDatafromExcel("Contact Name", 0, 1);
		lastname = ExcelUtilities.getDatafromExcel("Contact Name", 1, 1);		

		organizationpage = new Organizationpage(driver);
		contactpage = new Contactpage(driver);
		createcontactpage = new CreateContactPage(driver);
		createorganizationpage = new CreateOrganizationPage(driver);

		homepage.organizationClick();
		organizationpage.createOrganizationIcon();
		createorganizationpage.organizationNameandSave(organization_name+RandomNumber);
		
		homepage.contactClick();
		contactpage.createContactIcon();
		createcontactpage.lastName(lastname);
		createcontactpage.organizationIcon();
		WebDriver_Utilities.switchToWindowBasedOnTitle(driver, "Accounts&action");
		createcontactpage.organizationSearchBrowser(organization_name, driver);
		createcontactpage.saveCreateContact();  
	}

}
