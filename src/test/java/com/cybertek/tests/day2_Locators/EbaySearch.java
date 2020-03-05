package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbaySearch {

        /*
        Task:
    Go to amazon  https://www.amazon.com/
    then  Go to Ebay   https://www.ebay.com/
    Enter a search term
    Click on search button
    Verify title contains search term
         */

    public static void main(String[] args) throws InterruptedException {
        //locaotors --> ID, name, classname,
        /*
        If class attribute's value has a space or spaces,
        driver cannot locate the element.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.ebay.com/");

        //I used name here just to practice
        WebElement searchBox = driver.findElement(By.name("_nkw"));

        Thread.sleep(4000);
      //   Keys.ENTER --> Click the Enter key
        searchBox.sendKeys("shoes" + Keys.ENTER);

//        WebElement searchBttn = driver.findElement(By.id("gh-btn"));
//        searchBox.click();

     //   Verify title contains search term
        //expected vs actual
        Thread.sleep(4000);
        String expectedPartialTitle = "shoes";
        String actual = driver.getTitle();

        if(actual.contains(expectedPartialTitle)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }











    }
}
