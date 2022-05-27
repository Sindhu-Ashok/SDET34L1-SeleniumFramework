package com.SDET34L1_GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to maintain all excel specific Common methods
 * @author sin42
 *
 */

public class ExcelUtilities
{
	static Workbook wb;
	/**
	 * Excel Path
	 * @param FilePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public static void openExcel(String FilePath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisexcel = new FileInputStream(FilePath);
		wb = WorkbookFactory.create(fisexcel);
		
	}
	
	/**
	 * This method is used to fetch the data
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String getDatafromExcel(String sheetname,int rowNum,int cellNum)
	{
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data; 
	}
	
	/**
	 * This method is used to create and set cell value into Excel
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @param message
	 */
	public static void createCell_Setcell(String sheetname,int rowNum,int cellNum,String value )
	{
		wb.getSheet(sheetname).getRow(rowNum).createCell(cellNum).setCellValue(value);
	}
	
	
	/**
	 * This method is used to Write in the excel
	 * @param filepath
	 * @throws IOException
	 */
	public static void saveExcelData(String savepath) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(savepath);
		wb.write(fos);
	}
	
	/**
	 * This method is used to Close the excel
	 * @throws IOException
	 */
	public static void closeExcel() throws IOException
	{
		wb.close();
	}
	
	/**
	 * This method is used to get the multiple data from excel
	 * @param sheetname
	 * @return
	 */
	public static Object[][] getMultipleDatafromExcel(String sheetname)
	{
		Sheet sheet = wb.getSheet(sheetname);
		Object[][] arr = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) 
		{
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
			}	
		}
		return arr;
	}
	
	
	
}







