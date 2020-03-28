package com.cybertek.tests.day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExamples {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("firefox");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1TitleTest(){
        driver.get("https://google.com");

        System.out.println(driver.getTitle());

        driver.get("https://steam.com");

        System.out.println(driver.getTitle());

    }

}
