package com.vtiger.contacts.Test;

import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.Contactpage;
import com.vtiger.ElementRepository.CreateContactPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateContactsTest extends BaseClass
{
	Contactpage contactpage;
	CreateContactPage createcontactpage;
	ContactInformationPage contactinformationpage;
	
	@Test(groups = "sanity", description = "testng:-CreateContactsTest")
	@Description("Description:-CreateContactsTest")
	@Epic("Epic:-CreateContactsTest")
	@Story("Story:-CreateContactsTest")
	@Step("Step:-CreateContactsTest")
	@Severity(SeverityLevel.CRITICAL)
	public void createContactTest() throws InterruptedException
	{
		String LastName = ExcelUtilities.getDatafromExcel("Contact Name", 1, 1)+RandomNumber;
		contactinformationpage = new ContactInformationPage(driver); 
		contactpage = new Contactpage(driver);
		createcontactpage = new CreateContactPage(driver);
		homepage.contactClick();
		contactpage.createContactIcon();
		createcontactpage.lastName(LastName);
		createcontactpage.saveCreateContact();
		String createdcontactname = contactinformationpage.lastNameConfirmation();
		javautil.ifValidation(LastName,createdcontactname);
	}
}
