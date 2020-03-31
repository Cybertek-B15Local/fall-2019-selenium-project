package com.cybertek.tests.day15_webtables;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTests extends TestBase {

    @BeforeMethod
    public void setUpTest(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.linkText("Sortable Data Tables")).click();

    }
    // GET WHOLE TABLE
    @Test
    public void printTable(){
        WebElement myTable = driver.findElement(By.id("table1"));
        System.out.println(myTable.getText());
    }

    // GET ALL HEADERS
    @Test
    public void getHeaders(){

    }
}
