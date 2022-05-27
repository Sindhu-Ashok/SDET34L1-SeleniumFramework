package com.SDET34L1_GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only Property file specific Common Methods
 * @author sin42
 *
 */

public class FileUtilities {
	
	static Properties property;
	/**
	 * This method is used to open the Property file 
	 * @throws IOException 
	 */
	
	public static void openPropertyFile(String PathofFile) throws IOException	
	{	
		 FileInputStream fis = new FileInputStream(PathofFile);
		 property = new Properties();
		 property.load(fis);
	}
	
/**
 * This method consists of the key values
 * @param key
 * @return
 * @throws IOException
 */
	
	public static String fetchData_PF(String key) throws IOException
	{
		String value = property.getProperty(key);
		return value;	
	}
}