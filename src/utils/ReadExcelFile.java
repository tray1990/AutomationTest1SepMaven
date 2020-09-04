package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	ConstantValues constantValues = new ConstantValues() ; 
	String path = constantValues.sExcelPath;

	@SuppressWarnings("finally")
	public String readFromExcel(String sExcelPath, String sSheet, int iRow, int iCell) {
		String sValueReturn = "";
		System.out.println("Excel input file path is : "+sExcelPath);

		try {
			FileInputStream fis = new FileInputStream(sExcelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);		
			XSSFSheet sheet = workbook.getSheet(sSheet); // Dynamically Check with iteration HH Sheet.
			sValueReturn = sheet.getRow(iRow).getCell(iCell).toString();
			System.out.println("Input Value is : "+sValueReturn);
//			log.writeIntoLog(sValueReturn, true);
			workbook.close();

		} catch (FileNotFoundException fnf) {
			sValueReturn = "";
			System.out.println("Input Value is : "+sValueReturn);

		} catch (IOException ioe) {
			sValueReturn = "";
			System.out.println("Input Value is : "+sValueReturn);

		} catch (Exception e) {
			sValueReturn = "";
			System.out.println("Input Value is : "+sValueReturn);

		} finally {
			return sValueReturn;
		}
	}
}