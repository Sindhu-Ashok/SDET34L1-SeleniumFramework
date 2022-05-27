package com.vtiger.TestCase;

import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;
import com.vtiger.ElementRepository.Contactpage;

public class ClickonContact_AlphabetsTest extends BaseClass
{
	@Test
	
	public void  clickonContact_AlphabetsTest()
	{
		String lastname = ExcelUtilities.getDatafromExcel("Contact Name", 1, 1);
		String alphabet = ExcelUtilities.getDatafromExcel("Contact Name", 2, 1);
		Contactpage contactpage = new Contactpage(driver);
		homepage.contactClick();
		contactpage.entercreateSearchTxt(alphabet);
		WebDriver_Utilities.dropDownHandle(contactpage.contactInDropdown(), "Last Name");
		contactpage.clickOncreateSearchBtn();
	}
}
