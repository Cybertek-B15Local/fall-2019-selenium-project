package com.cybertek.tests.office_hours4;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample extends TestBase {

    @Test
    public void type(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Dynamic Controls")).click();

//        inputField = driver.findElement(webdriver.By.id('gbqfq'));
//        driver.executeScript("arguments[0].setAttribute('value', '" + longstring +"')", inputField);

        WebElement webElement = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String text = "hello";

        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')", webElement);



    }
}
