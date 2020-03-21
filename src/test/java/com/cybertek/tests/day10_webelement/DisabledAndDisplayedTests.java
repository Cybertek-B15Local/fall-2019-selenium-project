package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledAndDisplayedTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    /*
    go to http://practice.cybertekschool.com/radio_buttons
    verify green is disabled
    verify black is enabled
     */

    @Test
    public void disabledTest() throws InterruptedException {
        Thread.sleep(2000);
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));
        // isEnabled --> returns true if the element is enabled, active
        System.out.println(green.isEnabled());
    }
}
