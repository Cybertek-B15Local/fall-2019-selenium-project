package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCssExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebElement todaysDeals = driver.findElement(By.cssSelector("a[tabindex='47']"));
        todaysDeals.click();

        String expexted = "Today's Deals";
        WebElement topHeader = driver.findElement(By.cssSelector(".nav-a-content"));
        System.out.println(topHeader.getText());

    }
}
