package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage 
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganizationIcon;
	
	public Organizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createOrganizationIcon()
	{
		createOrganizationIcon.click();
	}
}
