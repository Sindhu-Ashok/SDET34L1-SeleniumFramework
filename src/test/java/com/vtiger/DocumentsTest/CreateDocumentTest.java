package com.vtiger.DocumentsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.Java_Utilities;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;
import com.vtiger.ElementRepository.CreateDocumentsPage;
import com.vtiger.ElementRepository.DocumentInformationPage;
import com.vtiger.ElementRepository.DocumentsPage;
import com.vtiger.ElementRepository.Homepage;
import com.vtiger.ElementRepository.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest extends BaseClass
{
	String title;
	DocumentsPage documentpage;
	CreateDocumentsPage createdocumentpage;
	DocumentInformationPage documentinformationpage;
	@Test

	public  void createDocumentTest() throws InterruptedException
	{
		title = ExcelUtilities.getDatafromExcel("Documents", 1, 0);
		documentpage= new DocumentsPage(driver);
		createdocumentpage = new CreateDocumentsPage(driver);
		documentinformationpage = new DocumentInformationPage(driver);
 		homepage.documentsClick();
 		documentpage.createDocumentIcon();                                                     
 		createdocumentpage.documentTitle(title);
 		WebDriver_Utilities.switchToFrame(driver, 0);
 		createdocumentpage.descriptionArea(title+Keys.CONTROL+"abi");
 		WebDriver_Utilities.switchBackToHome(driver);
 		createdocumentpage.chooseFileBtn("C:\\Users\\sin42\\Desktop\\Sample.docx");
 		String documentconfirmation = documentinformationpage.documentConfirmationTxt();
 		javautil.ifValidation(title, documentconfirmation);	
	}
}
