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

        String expected = "Today's Deals";
        WebElement topHeader = driver.findElement(By.cssSelector(".nav-a-content"));
        System.out.println(topHeader.getText());

        if (expected.equals(topHeader.getText())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual " + topHeader.getText());
        }

        WebElement bottomHeader = driver.findElement(By.cssSelector("h1>div:nth-of-type(1)"));
        System.out.println(bottomHeader.getText());

        if (expected.equals(bottomHeader.getText())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + bottomHeader.getText());
        }

        driver.close();

    }
}
