package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1_GenericUtilities.WebDriver_Utilities;

public class CreateContactPage
{
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTxt;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement organiationIcon;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement lastNameConfirmationTxt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement organizationIcon;
	
	//Organization Search browser
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement organizationSearchTxt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement organizationSearchBtn;
	
	@FindBy(id="1")
	private WebElement idCount;
	
	
	//Constructor
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void firstName(String firstName)
	{
		firstNameTxt.sendKeys(firstName);
	}
	
	public void lastName(String lastName)
	{
		lastNameTxt.sendKeys(lastName);
	}
	
	public void saveCreateContact() throws InterruptedException
	{
		//Thread.sleep(2000);
		saveBtn.click();	
	}
	
	public void organizationClick() 
	{
		organiationIcon.click();
	}
	
	public void lastname_Save(String firstName, String lastName) 
	{
		lastNameTxt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public WebElement lastNameConfirmationTxt() 
	{
		return lastNameConfirmationTxt;
	}
	
	public void organizationIcon()
	{
		organizationIcon.click();
	}
	
	public void organizationSearchBrowser(String organization_name, WebDriver driver)
	{
		organizationSearchTxt.sendKeys(organization_name);
		organizationSearchBtn.click();
		idCount.click();
		WebDriver_Utilities.switchBackToHome(driver);
	}
}
