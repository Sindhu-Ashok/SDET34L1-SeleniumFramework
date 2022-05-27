package com.vtiger.practiceTest;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGBasicConfigAnnotationPracticeTest

{
	@BeforeSuite
	public void beforeSuiteTest()
	{
		Reporter.log("beforesuite1", true);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		Reporter.log("afterSuite1", true);
	}
	
	@BeforeClass
	public void beforeClass()
	{
		Reporter.log("beforeClass1", true );
	}
	
	@AfterClass
	public void afterClass()
	{
		Reporter.log("afterClass1", true);
	}
	
	@BeforeTest
	public void beforeTest1()
	{
		Reporter.log("BeforeTest1", true);
	}
	
	@BeforeTest
	public void beforeTest2()
	{
		Reporter.log("BeforeTest2", true);
	}
	
	@BeforeTest
	public void beforeTest3()
	{
		Reporter.log("BeforeTest3", true);
	}
	
	@AfterTest
	public void afterTest1()
	{
		Reporter.log("AfterTest1", true);
	}
	
	@AfterTest
	public void afterTest2()
	{
		Reporter.log("AfterTest2", true);
	}
	
	@BeforeMethod
	public void beforeMethod1()
	{
		Reporter.log("BeforeMethod1", true);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		Reporter.log("AfterMethod1", true);
	}
	
	@BeforeMethod
	public void beforeMethod2()
	{
		Reporter.log("BeforeMethod2", true);
	}
	
	@AfterMethod
	public void afterMethod2()
	{
		Reporter.log("AfterMethod2", true);
	}
	
}
