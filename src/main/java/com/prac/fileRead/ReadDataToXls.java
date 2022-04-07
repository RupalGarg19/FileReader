package com.prac.fileRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataToXls {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("Data.xlsx");
		FileInputStream fos = new FileInputStream(f);
		XSSFWorkbook excelWorkbook = new XSSFWorkbook(fos);
		XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);
		XSSFCell cell;
		int row = excelSheet.getPhysicalNumberOfRows();
		int col = excelSheet.getRow(0).getPhysicalNumberOfCells();
		String data[][]= new String[row][col];
		for(int i=0 ; i<row; i++){
			for(int j=0; j<col; j++){
				cell = excelSheet.getRow(i).getCell(j);
				String cellContents=cell.getStringCellValue();
				data[i][j] = cellContents;
				System.out.println(data[i][j]);
			}
		}
		fos.close();
	}
}
