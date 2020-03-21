package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    /*
    go to page radio buttons
    verify that none of the sports radio buttons are selected
     */
    @Test
    public void listOfRadioButtons() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //   driver.findElements --> returns a LIST of element
        // returns all the elements that match the given locator
        // if the locator does not match anhytihg, it does not throw exception, it just returns empty list

        List<WebElement> sports = driver.findElements(By.name("sport"));

        System.out.println(sports.size());

        for (WebElement radioButton : sports) {
            Assert.assertFalse(radioButton.isSelected());
        }
    }

    /*
    go to practice website
    get all the links present in the page
    print their text
     */
    @Test
    public void getAllLinksTest(){
        driver.get("http://practice.cybertekschool.com");

        // get all the links in a page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
    }



}
