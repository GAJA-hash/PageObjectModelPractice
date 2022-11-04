package com.infi.VBank.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * Here we do data driven process
 */
public class ExcelConfig 
{
	File f;
	
	FileInputStream fis;
	
	XSSFWorkbook wb;
	
	XSSFSheet sh;
	
	
	public ExcelConfig(String excelPath)
	{
		try
		{
			
		f=new File(excelPath);
		
		fis=new FileInputStream(f);
		
		wb=new XSSFWorkbook(fis);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public int getRowCount(String sheetName)
	{
		sh=wb.getSheet(sheetName);
		
		int rows=sh.getLastRowNum();
		
		rows=rows+1;
		
		return rows;
	}
	
	public int getColCount(String sheetName)
	{
		short cols=wb.getSheet(sheetName).getRow(0).getLastCellNum();
		
		return cols;
	}
	
	public String getData(String sheetName, int row, int col)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
		return data;
	}

}
