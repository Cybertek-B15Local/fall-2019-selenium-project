package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void test(){
        WebElement one = driver.findElement(By.xpath("//input[1]"));
        WebElement two = driver.findElement(By.xpath("//input[2]"));
        // by default one is not checked, two is checked
        System.out.println("is one selected: "+ one.isSelected());
        System.out.println("is two selected: "+ two.isSelected());

        Assert.assertFalse(one.isSelected());
        Assert.assertTrue(two.isSelected());

        // check the first checkbox
        // verify one is selected
        // verify two is selected
        System.out.println("check the first checkbox");
        one.click();
        System.out.println("is one selected: "+ one.isSelected());
        System.out.println("is two selected: "+ two.isSelected());

        Assert.assertTrue(one.isSelected());
        Assert.assertTrue(two.isSelected());

    }
}
