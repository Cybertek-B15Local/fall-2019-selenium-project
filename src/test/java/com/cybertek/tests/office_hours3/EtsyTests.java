package com.cybertek.tests.office_hours3;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EtsyTests extends TestBase {
    /*
    search for wooden spoon on etsy
    verify title contains the searchterm
    verify that default shipt to location is United States
    verify Ship to countries include Australia
     */

    @Test
    public void verifyCountryList() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://etsy.com");
        // for chrome users, wait until page loads
        waitForPageToLoad(5000);

        WebElement input = driver.findElement(By.id("global-enhancements-search-query"));


        input.sendKeys("wooden spoon"+ Keys.ENTER);

        // VERIFY TITLE
        String expectedTitle = "Wooden spoon | Etsy";

        // wait a little until title changes to right one

        // using explicit wait to wait until title contains Wooden spoon | Etsy
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertEquals(driver.getTitle(), expectedTitle);

        // VERIFY SHIP TO LOCATION

        // wait until element is FOUND in html
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Select shipToList = new Select(driver.findElement(By.name("ship_to")));

        String expectedDefaultCountry = "United States";
        // get the selected element and get its text
        String actualDefaultCountry =shipToList.getFirstSelectedOption().getText().trim();
        Assert.assertEquals(actualDefaultCountry, expectedDefaultCountry);

        // VERIFY THAT Ship to countries include Australia

        // get all options is a list of strings
        List<String> options = BrowserUtils.getElementsText(shipToList.getOptions());

        for (String option : options) {
//            option.trim().equals("Austalia")
        }


        Assert.assertTrue(options.contains("Australia"));

        // VERIFY FREE SHIPPING IS NOT CLICKED
        WebElement freeeShipping = driver.findElement(By.name("free_shipping"));
        Assert.assertFalse(freeeShipping.isSelected());

        // VERIFY URL CHANGES WHEN FREE SHIPPING IS CLICKED
        // click using JS
        WebElement freeeShippingLabel = driver.findElement(By.xpath("//label[.='FREE shipping']"));
        freeeShippingLabel.click();

        String expectedUrl = "free_shipping=true";
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedUrl));


    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
}
