package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeFactory {

    public static void main(String[] args) {
        //go to google

     //   WebDriverManager.chromedriver().setup();
    //    WebDriver driver = new ChromeDriver();


        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://google.com");




    }
}
