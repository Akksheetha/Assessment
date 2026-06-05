package com.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "testData1")
    public static Object[][] getData() throws Exception {

        FileInputStream file = new FileInputStream("FileInputStream file = new FileInputStream(\r\n"
        		+ "\"C:\\\\Users\\\\akksh\\\\OneDrive\\\\Desktop\\\\Testing modules\\\\Java Training\\\\Akksheetha M - Assessment 19\\\\Assessment_Questions\\\\Data Provider.xlsx\"\r\n");

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        wb.close();
        file.close();

        return data;
    }
}