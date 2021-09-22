package com.crm.autodesk.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/* This class contains generic methods to read and write data from excel sheet
 * @author malathi
 */

public class ExcelFileUtility{
	/*this method will read data from excel sheet wrt to row number and cell number
	 * throws throwable
	 
	 */
	public String getExcellData(String sheetName, int rownum, int cellnum) throws Throwable
	
	{
		
		FileInputStream fis=new FileInputStream(Ipathconstants.ExcelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell= row.getCell(cellnum);
		String value= cell.getStringCellValue();
		return value;
		
	}
public int getintExcellData(String sheetName, int rownum, int cellnum) throws Throwable
	
	{
		
		FileInputStream fis=new FileInputStream(Ipathconstants.ExcelFilePath);
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell= row.getCell(cellnum);
		double value= cell.getNumericCellValue();
		int val=(int)value;
		
		return val;
		
	}

/* This method return the data fuull in sheet
 * 
 */
public Object[][] getExcellData(String SheetName ) throws Throwable
{
	FileInputStream fis=new FileInputStream(Ipathconstants.ExcelFilePath);
	Workbook wo = WorkbookFactory.create(fis);
	Sheet sheet=wo.getSheet(SheetName);
	int lastrow = sheet.getLastRowNum();
	int lastCell = sheet.getRow(0).getLastCellNum();
	Object [][] data =new Object[lastrow][lastCell];
	
	for (int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lastCell;j++)
         {
	            data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
	
	
           }
	   }
	return data;
     }
	
	
	

}



