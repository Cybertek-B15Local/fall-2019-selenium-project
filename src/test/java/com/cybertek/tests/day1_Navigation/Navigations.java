package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

    public static void main(String[] args) throws InterruptedException {
       /*
       Navigation:
       driver.navigate().to("URL")
       driver.navigate().back()
       driver.navigate().forward()
       driver.navigate().refresh()
        */


        // go to practice --> go to google --> back to practice
        // --> forward to google

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        ChromeDriver driver1 = new ChromeDriver();




        String practiceWebURL = "http://practice.cybertekschool.com/";
        // go to practice
        driver.get(practiceWebURL);

        //I want to see the full window
     //   driver.manage().window().fullscreen();
        driver.manage().window().maximize();


        Thread.sleep(3000);

       // go to google
        String gglURL = "https://www.google.com";
        driver.navigate().to(gglURL);
        Thread.sleep(3000);
        //back to practice
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        driver.navigate().refresh();


        //close drive
        //close the current web browser ONLY
        driver.close();

        //close down all the windows in a browser
        driver.quit();



        //come back at 1:50 pm








    }
}
