package com.cybertek.tests.office_hours3;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EtsyTests extends TestBase {
    /*
    search for wooden spoon on etsy
    verify title contains the searchterm
    verify that default shipt to location is Ship to
    verify Ship to countries include Australia
     */

    @Test
    public void verifyCountryList(){
        driver.get("https://etsy.com");
        WebElement input = driver.findElement(By.id("global-enhancements-search-query"));
        input.sendKeys("wooden spoon"+ Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}
