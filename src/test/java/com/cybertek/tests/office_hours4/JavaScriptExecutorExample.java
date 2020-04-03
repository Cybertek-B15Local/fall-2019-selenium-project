package com.cybertek.tests.office_hours4;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptExecutorExample extends TestBase {

    @Test
    public void type() {
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Dynamic Controls")).click();

//        inputField = driver.findElement(webdriver.By.id('gbqfq'));
//        driver.executeScript("arguments[0].setAttribute('value', '" + longstring +"')", inputField);

        WebElement webElement = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text = "hello";

        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", webElement);

    }

    @Test
    public void highlight() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.tagName("h1"));

        highlight(text);

        List<WebElement> list = driver.findElements(By.cssSelector("li>a"));
        for (WebElement link : list) {
            highlight(link);
        }

    }


    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(200);
        jse.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(200);

    }

}
