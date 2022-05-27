package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage
{
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement productConfirmationTxt;
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String productConfirmationTxt()
	{
		return productConfirmationTxt.getText();
	}
}
