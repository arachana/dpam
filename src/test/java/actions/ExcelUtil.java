package actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtil {
	/*
	 1. File path
	 2. InputStream--Filepath
	 3. Workbook-user input stream
	 4. Worksheet-Use workbook
	 5. Rows=use worksheet
	 6. Column
	 7. Cell
	 8. Data
	 */
	
XSSFWorkbook workbook;
XSSFSheet sheet;
XSSFRow row;
XSSFCell datacell;
XSSFCell keycell;
String[][] data;

@Test

public String[][] readExcelData(String dataFile,String dataSheet){	
	
	try {
		FileInputStream fis=new FileInputStream(dataFile);
		workbook=new XSSFWorkbook(fis);	
		sheet=workbook.getSheet(dataSheet);
		row=sheet.getRow(1);
		int rowCount=sheet.getLastRowNum();
		int lastCellNum=sheet.getRow(0).getLastCellNum();
		
		data=new String[rowCount][lastCellNum];
	
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				datacell=sheet.getRow(i).getCell(j);
				data[i-1][j]=datacell.getStringCellValue();
			}
		}		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
}
	
}
