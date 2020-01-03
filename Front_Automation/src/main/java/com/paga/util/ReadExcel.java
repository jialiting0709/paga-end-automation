package com.paga.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	/**
	 * Getdatafromexcel static method is used to read the data of the page specified in the xlsx file under the resources directory. 
	 * The first row of data is not read as the header information and is automatically skipped.
	 * @param excelFileName The xlsx filename under resources does not need a path
	 * @param sheetName The sheet page name of the data to be read
	 * @return Return data as a 2D array
	 */
	public static Object[][] getDataFromExcel(String excelFileName,String sheetName){
		Object[][] obj = null;
		Workbook wb = null;
		InputStream resourceAsStream = ReadExcel.class.getClassLoader().getResourceAsStream(excelFileName);
		try {
			wb = new XSSFWorkbook(resourceAsStream);
			Sheet sheet = wb.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
			obj =new Object[lastRowNum][lastCellNum];
			for(int i=1;i<=lastRowNum;i++) {
				for(int j=0;j<lastCellNum;j++) {
					String str = sheet.getRow(i).getCell(j).getStringCellValue();
					if(str.equalsIgnoreCase("<Empty>")) {
						obj[i-1][j] = "";        
					}else {
						obj[i-1][j] = str; 
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return obj;
	} 
	
}

