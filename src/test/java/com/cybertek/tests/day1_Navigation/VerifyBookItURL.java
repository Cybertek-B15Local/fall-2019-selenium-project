package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyBookItURL {

    public static void main(String[] args) {
        /*
        Task 2:
2. Go to Bookit login page
https://cybertek-reservation-qa.herokuapp.com/sign-in
2. Verify that URL contains “cybertek-reservation”
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");

        driver.manage().window().maximize();

        String expectedPartialURL = "cybertek-reservation";
        String actualURL = driver.getCurrentUrl();
        //https://cybertek-reservation-qa.herokuapp.com/sign-in

        if(actualURL.contains(expectedPartialURL)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("expectedPartialURL: " + expectedPartialURL);
            System.out.println("Actual URL: " + actualURL);
        }


    }
}
