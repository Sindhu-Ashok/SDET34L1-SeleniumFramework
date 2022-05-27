package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SamplePropertyFileTest

{
	public static void main(String[] args) throws IOException 
	{
		//Step 1: Converting property file to Java readable object
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//Step 2: Create object for Property file
		
		Properties property = new Properties();
		
		//Step 3: Load all the keys
		
		property.load(fis);
		
		//Step 4: Fetch the data by using KEY
		
				String url = property.getProperty("url");
				String userName = property.getProperty("userName");
				String password = property.getProperty("password");
				String timeout = property.getProperty("timeout");
				String browser = property.getProperty("browser");
				
				System.out.println(url);
				System.out.println(userName);
				System.out.println(password);
				System.out.println(timeout);
				System.out.println(browser);
		
	}
		
}
