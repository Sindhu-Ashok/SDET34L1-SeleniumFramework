package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage 
{
	@FindBy(xpath="//span[@id='dtlview_Title']")
	private WebElement documentConfirmationTxt;
	
	public DocumentInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String documentConfirmationTxt()
	{
		return documentConfirmationTxt.getText();
	}
	
}
