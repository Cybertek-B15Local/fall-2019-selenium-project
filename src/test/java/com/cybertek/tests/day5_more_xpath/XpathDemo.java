package com.cybertek.tests.day5_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {

    public static void main(String[] args) {

        // get chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // open browser
        driver.get("http://practice.cybertekschool.com/multiple_buttons");


// represent an element from page
        // where the elements come from?
        // form the finELement methods
        // how  finELement finds elements?
        // using locators

        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        // start interacting with the element
        String txt = buttonOne.getText();
        System.out.println(txt);

        WebElement buttonTwo = driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(buttonTwo.getText());

        System.out.println(driver.findElement(By.xpath("//button[3]")).getText());

        WebElement buttonFour = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(buttonFour.getText());

        WebElement buttonFive = driver.findElement(By.xpath("//button[.='Button 5']"));
        System.out.println(buttonFive.getText());

        WebElement buttonSix= driver.findElement(By.xpath("//button[@id='disappearing_button']"));
        // element.getAttribute("value")  --. method to get text form element, used with input boxes alot
        // get text of the element
        System.out.println(buttonSix.getAttribute("innerHTML"));

        // if none of the works use outerHTML
        System.out.println(buttonSix.getAttribute("outerHTML"));

    }
}
