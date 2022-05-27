package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	//Declaring the elements and specifying access specifier as private
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userNameText;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordText;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement submitBtn;
	
	//Constructor
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//Pagefactory is concerte class and initelement will use to
	}
	
	//Business Library 
	
	public void loginToApp(String userName, String password) 
	{
		userNameText.sendKeys(userName);
		passwordText.sendKeys(password);
		submitBtn.click();
	}
	
}
