package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage
{
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement organizationConfirmationTxt;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public  String organizationConfirmationTxt()
	{
		return organizationConfirmationTxt.getText();
	}
}


