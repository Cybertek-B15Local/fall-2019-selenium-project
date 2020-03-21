package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
        System.out.println("Is green enabled: "+green.isEnabled());
        System.out.println("Is black enabled: "+black.isEnabled());
        Assert.assertFalse(green.isEnabled());
        Assert.assertTrue(black.isEnabled());

    }


    @Test
    public void disabledTestWithAttribute() throws InterruptedException {
        Thread.sleep(2000);
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));


        System.out.println("black: "+ black.getAttribute("disabled"));
        System.out.println("green: "+ green.getAttribute("disabled"));

        // verify that certain value is equal to null. verify element is enabled
        Assert.assertEquals(black.getAttribute("disabled"), null);
        // VERIFY THAT VALUE OF black.getAttribute("disabled") IS NULL
        Assert.assertNull(black.getAttribute("disabled"));

        // verify that certain value is equal to TRUE. verify element is DISALBED
        Assert.assertEquals(green.getAttribute("disabled"), "true");
        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled")));
    }

    @Test
    public void testElementVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username = driver.findElement(By.id("username"));
        WebElement start = driver.findElement(By.tagName("button"));

        // verify that username is not visible
        /// isDisplayed --> returns true element we found in HTML is visible on page
        System.out.println("Username is visible: " + username.isDisplayed());
        Assert.assertFalse(username.isDisplayed());

        System.out.println("click on start");
        start.click();

        Thread.sleep(7000);
        System.out.println("Username is visible: " + username.isDisplayed());
        Assert.assertTrue(username.isDisplayed());

    }
}
