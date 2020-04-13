package com.cybertek.tests.office_hours4;

import com.cybertek.utilities.Driver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CountryInformationDDT {

    WebDriver driver;
    Workbook workbook;
    Sheet workSheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;


    @BeforeMethod
    public void setUp() throws IOException {
//        driver = Driver.getDriver();

        fileInputStream = new FileInputStream("src/test/resources/Countries.xlsx");
        workbook = WorkbookFactory.create(fileInputStream);
        workSheet = workbook.getSheet("Countries");
    }

    @Test
    public void test() {
        int count = workSheet.getPhysicalNumberOfRows();
        System.out.println("count = " + count);

        for (int i = 1; i < count; i++) {
            Row currentRow = workSheet.getRow(i);
            String execute = currentRow.getCell(0).toString();
            System.out.println("execute = " + execute);
            if (execute.equals("y")) {
                // execute the test
                String country = currentRow.getCell(1).toString();
                String capital = currentRow.getCell(2).toString();
            } else {
                // skip
                continue;
            }
        }

    }
}
