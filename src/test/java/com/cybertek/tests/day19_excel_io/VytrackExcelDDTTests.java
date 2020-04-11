package com.cybertek.tests.day19_excel_io;

import com.cybertek.base.VytrackTestBase;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class VytrackExcelDDTTests extends VytrackTestBase {

    // this test will get test data from a data provider getUserData
    @Test(dataProvider = "getUserData")
    public void userDetailsTest(String username, String password, String firstname, String lastname) {
        test = report.createTest("User details test for "+username);
        test.info("login to vytrack");
        loginPage.login(username, password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        test.info("Get expected value");
        String actualName = dashboardPage.accountHolderName.getText();
        test.info("Verify username");
        assertEquals(actualName, firstname + " " + lastname);
        test.pass("pass user details test for "+username);
    }

    @DataProvider(name = "getUserData")
    public Object[][] getData() throws IOException {
        // DataProvider has a return type 2d array
        // we have to read the excel file, put its contents into 2d array and return

        FileInputStream file = new FileInputStream("src/test/resources/Vytrack testusers.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet workSheet = workbook.getSheet("QA3-short");

        int rowCount = workSheet.getPhysicalNumberOfRows() - 1;
        int colCount = workSheet.getRow(0).getLastCellNum() - 1;
        // 2d array that willl contain the excel data
        Object[][] data = new Object[rowCount][colCount];
        // iterate the worksheet.
        // i =1 --> start with second row
        // i <= rowCount  --> including the last row
        for (int i = 1; i <= rowCount; i++) {
            // get the row current index
            Row row = workSheet.getRow(i);
            // iterate the inner loop
            for (int j = 0; j < colCount; j++) {
                // get each cell from the row
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.toString();
            }
        }

        return data; // BREAK 2.05
    }
}
