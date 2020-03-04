package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURL {

    /*
    1. go to Etsy  https://www.etsy.com/
    2. Verify URL

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        //for verify title --> getTitle()
        //for verify URL -->

        String expectedURL = "https://www.etsy.c/";

        String actualURL = driver.getCurrentUrl();

      if(expectedURL.equals(actualURL)){
            System.out.println("pass");
        }else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedURL);
          System.out.println("The actual URL is: " + actualURL );
        }

      driver.close();



    }


}
