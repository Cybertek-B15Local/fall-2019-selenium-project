package com.cybertek.tests.day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExamples {

    WebDriver driver;
    // create web object
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1TitleTest(){
        driver.get("https://google.com");

        System.out.println(driver.getTitle());

        driver.get("https://store.steampowered.com/");

        // wait for the title of the second page

        // start waiting for title contain text
        wait.until(ExpectedConditions.titleContains("Steam"));

        System.out.println(driver.getTitle());

    }

    @Test
    public void test2WaitForVisible(){

    }

}
