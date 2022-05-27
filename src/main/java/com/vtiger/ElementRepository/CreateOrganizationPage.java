package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage
{
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgnaizationNameTxt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])")
	private WebElement saveOrganizationBtn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationConfirmation;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropdown;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void organizationName(String organization_name)
	{
		orgnaizationNameTxt.sendKeys(organization_name);
	}
	
	public void organizationNameandSave(String organization_name)
	{
		orgnaizationNameTxt.sendKeys(organization_name);
		saveOrganizationBtn.click();
	}
	
	public void saveOrganization()
	{
		saveOrganizationBtn.click();
	}
	
	public WebElement organizationConfirmation()
	{
		return organizationConfirmation;
	}
	
	public WebElement industryDropdown()
	{
		return industryDropdown;
	}
	
	public WebElement typeDropdown()
	{
		return typeDropdown;
	}
}
