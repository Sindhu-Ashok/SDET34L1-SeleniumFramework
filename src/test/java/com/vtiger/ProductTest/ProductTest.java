package com.vtiger.ProductTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SDET34L1_GenericUtilities.BaseClass;
import com.SDET34L1_GenericUtilities.ExcelUtilities;
import com.SDET34L1_GenericUtilities.FileUtilities;
import com.SDET34L1_GenericUtilities.ConstantPath;
import com.SDET34L1_GenericUtilities.WebDriver_Utilities;
import com.vtiger.ElementRepository.CreateProductPage;
import com.vtiger.ElementRepository.Homepage;
import com.vtiger.ElementRepository.Loginpage;
import com.vtiger.ElementRepository.ProductInformationPage;
import com.vtiger.ElementRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductTest extends BaseClass
{
	String data;
	ProductPage productpage;
	CreateProductPage createproductpage;
	ProductInformationPage productinformation;
	
	@Test(groups = {"sanity", "regression"})
	public void productTest()
	{
		data = ExcelUtilities.getDatafromExcel("Product Name", 0, 0);
		productpage = new ProductPage(driver);
		createproductpage = new CreateProductPage(driver);
		productinformation = new ProductInformationPage(driver);
		homepage.productClick();
		productpage.createProductIcon();
		createproductpage.productNameandSave(data);
		String productconfirmed = productinformation.productConfirmationTxt();
		javautil.ifValidation(productconfirmed, productconfirmed);
	}
}
