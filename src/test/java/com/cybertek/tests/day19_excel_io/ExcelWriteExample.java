package com.cybertek.tests.day19_excel_io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelWriteExample {

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
//        workSheet = workbook.getSheetAt(5);

        // workbook.getSheet --> get sheet using name
        workSheet = workbook.getSheet("QA3-short");
    }


    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close();
    }


    @Test
    public void readAndWrite(){
        // iterate get all the rows
        for (int i = 1; i < workSheet.getPhysicalNumberOfRows(); i++) {
            Row currentRow = workSheet.getRow(i);
            String username = currentRow.getCell(0).toString();
            String password = currentRow.getCell(1).toString();
            String firstname = currentRow.getCell(2).toString();
            String lastname = currentRow.getCell(3).toString();
            String result = currentRow.getCell(4).toString();
            System.out.println("ROW " + i);
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("firstname = " + firstname);
            System.out.println("lastname = " + lastname);
            System.out.println("result = " + result);
            // did some test, now want to write result back to excel
            // setCellValue --> enter the given text to cell
            currentRow.getCell(4).setCellValue("PASS");
            // get the updated value
            result = currentRow.getCell(4).toString();
            System.out.println("new result = " + result);

        }
    }

}
