package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage 
{
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement campaignConfirmationTxt;
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=DetailView&record=65']")
	private WebElement campaignProductConfirmationTxt;
	
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String campaignConfirmationTxt()
	{
		return campaignConfirmationTxt.getText();
	}
	
	public String campaignProductConfirmationTxt()
	{
		return campaignProductConfirmationTxt.getText();
	}
	
}
