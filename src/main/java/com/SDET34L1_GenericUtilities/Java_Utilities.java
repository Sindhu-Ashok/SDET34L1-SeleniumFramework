package com.SDET34L1_GenericUtilities;

import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This method is used to Convert
 * @author sin42
 *
 */

public class Java_Utilities {
	
/**
 * Long
 * @param value
 * @return
 */
	
	public long stringtoLong(String timeout)
	{
		return Long.parseLong(timeout);
		
	}
	/**
	 * This method is used to generate Random numbers
	 * @param limit
	 * @return
	 */
	
	public int getRandomNum(int limit)
	{
		Random random = new Random();
		return random.nextInt(limit);
	}
	
	/**
	 * This method is used to print the statement
	 * @param message
	 */
	public void printStatement(String message)
	{
		System.out.println(message);
	}
	
	/**
	 * This method is used to validate the statement 
	 */
	public void ifValidation(String actualresult, String expectedresult)
	{
	if(actualresult.contains(expectedresult))
	{
		System.out.println("Created successfully");
	}
	
	}
	
	/**
	 * This method is used to is used to validate the excel 
	 * @param sessionID
	 * @param value
	 * @param expectedSessionId
	 * @param SheetName
	 * @param rowNum
	 * @param Cellnum
	 * @param expectedResult
	 * @param Status
	 */
	public void assertionThroughIfCondition(String sessionID,String value, String expectedSessionId, 
			String SheetName, int rowNum, int Cellnum,String expectedResult, String Status)
	{
		
		if(sessionID.contains(expectedSessionId))
		{
			ExcelUtilities.createCell_Setcell(SheetName, rowNum, Cellnum, expectedResult);
			ExcelUtilities.createCell_Setcell(SheetName, rowNum, Cellnum, Status);
		}
	}
	
	/**
	 * This method is used to wait until the element is CLickable
	 * @param element
	 * @param Polingtime
	 * @param duration
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element, long Polingtime, int duration) throws InterruptedException
	{
		int count=0;
		while(count<=duration)
			try 
			{
				element.click();
				break;
			}
			catch (Exception e) 
			{
				Thread.sleep(Polingtime*500);
				count++;
			}
	}
	
}


	
	 
	
	
	
	
