package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    /*
    User story: As a user, I should be able to login VyTrack app.

      test case1: login successfully
    1. go to VyTrack login page
    2. write username   data: storemanager52
    3.write password           UserUser123
   4. click login button
   5.Verify that the user is on the homepage

   test cases2: login invalid cridential
      1. go to login page
      2.write invalid usr name
      3.write invalid password
      4. click login bttn
      5.verify that user see error message "Invalid user name or password."
     */
    public static void main(String[] args) {


     WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

       driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
       driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

       //find login bttn, and then click
        WebElement loginBttn = driver.findElement(By.id("_submit"));
        loginBttn.click();


          // login button can be found and clicked diractly
      //  driver.findElement(By.id("_submit")).click();

        /*
        Verify that you are in the home page
         */

        String expectedTitle = "Dashboard";
        String actulTitle = driver.getTitle();

        if(expectedTitle.equalsIgnoreCase(actulTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }







    }


}
