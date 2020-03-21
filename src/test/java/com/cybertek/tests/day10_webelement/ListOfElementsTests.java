package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        // get the text of each link and print

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }


    /*
    go to amazon
    search for paper towels
    print the number of results
    print the first result
    print the second result
    print the last result
     */

    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement input  = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels"+ Keys.ENTER);

        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));

        Thread.sleep(2000);
        System.out.println("Number of results: "+ allResults.size());

        System.out.println("First result: "+allResults.get(0).getText());
        System.out.println("Second result: "+allResults.get(1).getText());
        System.out.println("Last result: "+ allResults.get(allResults.size()-1).getText());


    }


}
