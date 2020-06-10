package com.qa.xero.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xfile,String xsheet) throws IOException {
		fis=new FileInputStream(xfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xsheet);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
		
	}
	
	public static int getcolCount(String xfile,String xsheet,int rownum) throws IOException {
		fis=new FileInputStream(xfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xsheet);
		row=sheet.getRow(rownum);
		int colCount=row.getLastCellNum();
		return colCount;
		
	}
	
	public static String getCellData(String xfile,String xsheet,int rownum,int colnum) throws IOException {
		fis=new FileInputStream(xfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fis.close();
		return data;
		
		
	}
	
	
	public static void setCellData(String xfile,String xsheet,int rownum,int colnum,String data) throws IOException {
		fis=new FileInputStream(xfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
		
		
	}
	
	
}
