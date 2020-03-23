package com.cybertek.tests.office_hours2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SelectClassPracticeTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /*
    go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    verify that table has dropdown with values Family, Friends, Coworkers, Businesses, Contacts

    select option Coworkers
    verify that that Coworkers is now selected
    select options Contacts
    verify that contacts is selected
     */
    @Test
    public void test() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        // getOptions --> gives all available options as a list of web elements
        List<WebElement> allOptionsEl = categories.getOptions();

        System.out.println("Number of options: " + allOptionsEl.size());

        List<String> expectedOptions = Arrays.asList("Family", "Friends", "Coworkers", "Businesses", "Contacts");

        // given a list web elements, extract the text of the elements into new list of strings

    }
}
