package com.cybertek.tests.day19_excel_io;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelExample {
    // path to the location of the excel file.
    private String filePath = "src/test/resources/Vytrack testusers.xlsx";

    // creates connection between jvm and the file.
    private FileInputStream fileInputStream;

    // represents the excel file
    private Workbook workbook;

    // represents the sheet that contains the actual data
    private Sheet workSheet;

    @BeforeMethod
    public void setUp() throws IOException {
        // initialize the input stream by giving the file location
        fileInputStream = new FileInputStream(filePath);

        // create the workbook the input stream
        // WorkbookFactory.create --> this is used to create workbook from inputstream
        workbook = WorkbookFactory.create(fileInputStream);

        // workbook.getSheetAt --> get the sheet from excel based on 0 based count
        workSheet = workbook.getSheetAt(5);

    }

    @Test
    public void rowAndColumnCount(){
        System.out.println(workSheet.getSheetName());
    }

}
















