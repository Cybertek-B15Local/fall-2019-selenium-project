package com.cybertek.tests.day15_webtables;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTablesTests extends TestBase {

    @Test
    public void printTable(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        WebElement myTable = driver.findElement(By.id("table1"));
        System.out.println(myTable.getText());
    }
}
