package com.vtigerCampaignName.Test;

import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;
import com.vtiger.ElementRepository.CampaignInformationPage;
import com.vtiger.ElementRepository.CampaignPage;
import com.vtiger.ElementRepository.CreateCampaignPage;

	public class CreateCampaignNamewithProductTest extends BaseClass
{
	String campaignName;
	String productname;
	CampaignPage campaignpage;
	CreateCampaignPage createcampaignpage;
	CampaignInformationPage campaignInformationPage;
	@Test
	
	public void createCampainNamewithProductTest()
	{
		campaignName = ExcelUtilities.getDatafromExcel("Campaign", 1, 0);
		productname = ExcelUtilities.getDatafromExcel("Product Name", 0, 0);	
		campaignpage = new CampaignPage(driver);
		createcampaignpage = new CreateCampaignPage(driver);
		campaignInformationPage= new CampaignInformationPage(driver);
		
		homepage.moreMouseoverAndcampaignClick(driver, webdriver_utilities);
		campaignpage.createCampaignIcon();
		createcampaignpage.campaignName(campaignName);
	
		createcampaignpage.campaign_ProductIcon();
		WebDriver_Utilities.switchToWindowBasedOnTitle(driver, "Products&action");
		createcampaignpage.productSearchandClick(productname);
		WebDriver_Utilities.switchToWindowBasedOnTitle(driver, "Campaigns&action");
	//	WebDriver_Utilities.switchBackToHome(driver);
		createcampaignpage.campaignSave();
		
		//String campainproductname = campaignInformationPage.campaignProductConfirmationTxt();
		//javautil.ifValidation(productname, campainproductname);
	}
}
