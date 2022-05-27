package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignNameTxt;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveCampaignBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement campaign_ProductIcon;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement productSearchTxt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement productSearchBtn;
	
	@FindBy(id="1")
	private WebElement idCount;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void campaignName(String campaign_name)
	{
		campaignNameTxt.sendKeys(campaign_name);
	}
	
	public void campaignSave()
	{
		saveCampaignBtn.click();
	}
	
	public void campaignNameAndSaveBtn(String campaign_name)
	{
		campaignNameTxt.sendKeys(campaign_name);
		saveCampaignBtn.click();
	}
	
	public void campaign_ProductIcon()
	{
		campaign_ProductIcon.click();
	}
	
	public void productSearchandClick(String product)
	{
		productSearchTxt.sendKeys(product);
		productSearchBtn.click();
		idCount.click();
	}
	
}
