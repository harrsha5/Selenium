package com.app.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderExcel {
    @DataProvider(name="excelData", parallel = true)
    public String[][] getData() throws IOException {
        File excelFile = new File("C:/Projects/SeleniumPractice/src/test/resources/SearchData.xlsx");
        System.out.println(excelFile.exists());
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
         int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[noOfRows-1][noOfColumns];
        for(int i = 0; i < noOfRows-1; i++){
            for(int j=0; j<noOfColumns;j++){
                //System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                // DataFormatter is to convert any data to String format
                DataFormatter df = new DataFormatter();
                //System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
            }
        }
        workbook.close();
        fis.close();
/*        for (String[] dataArray:data) {
            System.out.println(Arrays.toString(dataArray));
        }*/
        return data;

    }
}
