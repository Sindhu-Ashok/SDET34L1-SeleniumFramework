package com.vtiger.practiceTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestNG extends TestNGBasicConfigAnnotationPracticeTest{
	
	@Test(retryAnalyzer = com.SDET34L1_GenericUtilities.RetryAnalyserImplementation.class)
	public static void practicetest() 
	{
		Reporter.log("heyyyyyy",true);
		Reporter.log("Byyeee",true);
		Reporter.log("Tadaaaaa",true);
		Reporter.log("Heheheeee",true);
		Reporter.log("Ohhhhhhhh",true);
		Assert.assertEquals("abc","bcd");
	}
	
	@Test
	public static void practicetest1() 
	{
		Reporter.log("Byyeeee", true);
		Assert.assertEquals("abd","cbbc");
		Reporter.log("Hiieeeeeeee", true);
	}
	
}
