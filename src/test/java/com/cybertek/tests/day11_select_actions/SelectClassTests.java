package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectClassTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void getSelectedOption(){
        // FIND THE ELEMENT THAT HAS SELECT TAG
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // create a select class using the web element
        Select dropdownList = new Select(dropdown);

        // get the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
        // verify selected option
        Assert.assertEquals(selectedOption.getText(), "Please select an option");
    }

    @Test
    public void selectFromList() throws InterruptedException {
        // get the element with select tag
        WebElement dropdown = driver.findElement(By.id("state"));
        // create select class
        Select states = new Select(dropdown);

        // TODO selectByVisibleText --> selects by the text of the option
        states.selectByVisibleText("Iowa");
        Thread.sleep(1000);
        states.selectByVisibleText("Vermont");
        Thread.sleep(1000);
        states.selectByVisibleText("Kentucky");
        Thread.sleep(1000);

        // TODO selectByIndex --> selects based on the index of the option, 0 based count
        states.selectByIndex(0);
        Thread.sleep(1000);
        states.selectByIndex(10);
        Thread.sleep(1000);
        states.selectByIndex(20);
        Thread.sleep(1000);

        // TODO selectByValue--> selects based on the value of the value attribute of the option
        // TODO selectByValue --> it is not select text
        states.selectByValue("VA");
        Thread.sleep(1000);
        states.selectByValue("SC");
        Thread.sleep(1000);
        states.selectByValue("CO");
        Thread.sleep(1000);
        states.selectByValue("NE");

    }
}
