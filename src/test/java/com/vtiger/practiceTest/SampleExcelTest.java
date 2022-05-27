package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SampleExcelTest
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//Step1: Specify the path
		FileInputStream fis = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		
		//Step2: Open excel
		Workbook w = WorkbookFactory.create(fis);
		
		//Step3: Specify sheetname
		Sheet s = w.getSheet("Sheet1");
		
		//Step4: Specify rowcount
		Row r = s.getRow(1);
		
		//Step5: Specify cellcount
		Cell c = r.getCell(0);
		
		String data = c.getStringCellValue();
		
		
		System.out.println(data);
	}
}
