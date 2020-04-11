package com.cybertek.tests.day19_excel_io;

import com.cybertek.base.VytrackTestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
    public void userDetailsTest() {
        String username = "";
        String password = "";
        String firstname = "";
        String lastname = "";

        loginPage.login(username, password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualName = dashboardPage.accountHolderName.getText();
        assertEquals(actualName, firstname + " " + lastname);
    }

    @DataProvider(name = "getUserData")
    public Object[][] getData() throws IOException {
        // DataProvider has a return type 2d array
        // we have to read the excel file, put its contents into 2d array and return

        FileInputStream file = new FileInputStream("src/test/resources/Vytrack testusers.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet workSheet = workbook.getSheet("QA3-short");

        int rowCount = workSheet.getPhysicalNumberOfRows()-1;
        int colCount = workSheet.getRow(0).getLastCellNum()-1;

        Object[][] data = new Object[rowCount][colCount];

        return null;
    }
}
