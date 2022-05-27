package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement lastNameConfirmationTxt;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=DetailView&record=135']")
	private WebElement contactOrganizationConfirmationTxt;
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public  String lastNameConfirmation()
	{
		return lastNameConfirmationTxt.getText();
	}
	
	public  String contactOrganizationConfirmationTxt()
	{
		return contactOrganizationConfirmationTxt.getText();
	}
	
	
}
