package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactIcon;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement entercreatesearchTxt;
	
	@FindBy(xpath = "(//select[@id='bas_searchfield'])[1]")
	private WebElement contactInDropdown;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement clickOncreateSearchBtn;
	
	//Constructor
	public Contactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//method
	public void createContactIcon()
	{
		createContactIcon.click();
	}
	
	public void entercreateSearchTxt(String contact) 
	{
		entercreatesearchTxt.sendKeys(contact);
	}
	
	public  WebElement contactInDropdown()
	{
		return contactInDropdown;
	}
	
	public void clickOncreateSearchBtn()
	{
		clickOncreateSearchBtn.click();
	}
}
