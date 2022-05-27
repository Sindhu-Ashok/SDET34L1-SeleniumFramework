package com.SDET34L1_GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count = 0;
	int maxretry = 4;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<maxretry)
		{
			count++;
			return true;
		}
		return false;
	}
}
