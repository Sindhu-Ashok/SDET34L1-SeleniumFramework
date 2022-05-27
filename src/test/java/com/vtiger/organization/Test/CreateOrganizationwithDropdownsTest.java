package com.vtiger.organization.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationwithDropdownsTest extends BaseClass
{
	String organization_name;
	Organizationpage organization;
	CreateOrganizationPage createorganizationpage;
	private static final String Education = null;
	OrganizationInformationPage organizationinformation;
	
	@Test(groups = "sanity")
	public void createOrganizationwithDropdownTest() throws InterruptedException
	{	
		organization_name = ExcelUtilities.getDatafromExcel("Organization", 1, 1);
		organization = new Organizationpage(driver);
		createorganizationpage = new CreateOrganizationPage(driver);
		organizationinformation = new OrganizationInformationPage(driver);
		homepage.organizationClick();
		organization.createOrganizationIcon();
		createorganizationpage.organizationName(organization_name+RandomNumber);
		WebDriver_Utilities.dropDownHandle(createorganizationpage.industryDropdown(), "Education");
		WebDriver_Utilities.dropDownHandle(createorganizationpage.typeDropdown(), "Press");
		createorganizationpage.saveOrganization();
		String organizationconfirmation = organizationinformation.organizationConfirmationTxt();
		javautil.ifValidation(organization_name, organizationconfirmation);
	}
}
