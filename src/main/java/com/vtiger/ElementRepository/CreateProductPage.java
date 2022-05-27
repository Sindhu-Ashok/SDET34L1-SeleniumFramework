package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage
{
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameTxt;
	
	@FindBy(xpath = "(//input[@title ='Save [Alt+S]'])[1]")
	private WebElement saveProdcutBtn;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void productNameandSave(String productname)
	{
		productNameTxt.sendKeys(productname);
		saveProdcutBtn.click();
	}
	
	public void saveProduct() 
	{
		saveProdcutBtn.click();
	}
	
}

