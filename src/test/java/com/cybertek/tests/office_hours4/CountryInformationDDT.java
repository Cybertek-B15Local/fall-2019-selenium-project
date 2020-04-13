package com.cybertek.tests.office_hours4;

import com.cybertek.utilities.Driver;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CountryInformationDDT {

    WebDriver driver;
    Workbook workbook;
    Sheet workSheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;


    @BeforeMethod
    public void setUp() throws FileNotFoundException {
//        driver = Driver.getDriver();

        fileInputStream = new FileInputStream("src/test/resources/Countries.xlsx");

    }

    @Test
    public void test(){

    }
}
