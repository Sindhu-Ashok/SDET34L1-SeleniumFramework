package com.vtiger.organization.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;
import com.vtiger.ElementRepository.CreateOrganizationPage;
import com.vtiger.ElementRepository.Homepage;
import com.vtiger.ElementRepository.Loginpage;
import com.vtiger.ElementRepository.OrganizationInformationPage;
import com.vtiger.ElementRepository.Organizationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass
{
	Organizationpage organizationpage;
	CreateOrganizationPage createorganizationpage;
	String organization_name;
	OrganizationInformationPage organizationinformation;
	
	@Test(groups = "sanity")
	
	public void createOrganizationTest()
	{
		organization_name = ExcelUtilities.getDatafromExcel("Organization", 1, 1);
		organizationpage = new Organizationpage(driver);
		organizationinformation = new OrganizationInformationPage(driver);
		createorganizationpage = new CreateOrganizationPage(driver);
		homepage.organizationClick();
		organizationpage.createOrganizationIcon();
		createorganizationpage.organizationNameandSave(organization_name+RandomNumber);
		//String organizationconfirmation = organizationinformation.organizationConfirmationTxt();
		//javautil.ifValidation(organization_name, organizationconfirmation);
	
	}
}
