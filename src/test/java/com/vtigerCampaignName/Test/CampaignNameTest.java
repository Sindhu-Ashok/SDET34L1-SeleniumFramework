package com.vtigerCampaignName.Test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.vtiger.ElementRepository.CampaignInformationPage;
import com.vtiger.ElementRepository.CampaignPage;
import com.vtiger.ElementRepository.CreateCampaignPage;

public class CampaignNameTest extends BaseClass{
 String campaignName;
 CampaignPage campaignpage;
 CreateCampaignPage createcampaignpage;
 CampaignInformationPage campaignInformationPage;
 
	@Test(groups = "regression")
	public void createCampaignTest()
	{
		campaignName = ExcelUtilities.getDatafromExcel("Campaign", 1, 0);
		campaignpage = new CampaignPage(driver);
		createcampaignpage = new CreateCampaignPage(driver);
		campaignInformationPage= new CampaignInformationPage(driver); 
		homepage.moreMouseoverAndcampaignClick(driver, webdriver_utilities);
		campaignpage.createCampaignIcon();
		createcampaignpage.campaignNameAndSaveBtn(campaignName);
		String campaignnameconfirmed = campaignInformationPage.campaignConfirmationTxt();
		javautil.ifValidation(campaignName, campaignnameconfirmed);
	}
}
