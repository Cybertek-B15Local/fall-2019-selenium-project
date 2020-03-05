package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        //I want to get the value of type attribute
        // type="text"  -> getAttribute("attribute name")


        //locate username box
        WebElement unername =driver.findElement(By.name("username"));

        //<input type="text" name="username">

       String velueOfType =  unername.getAttribute("type");

        System.out.println("Velue of type is: " +  velueOfType);



        // <button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>

        WebElement loginbttn = driver.findElement(By.id("wooden_spoon"));

        //i want to print class attributes velue

        System.out.println(loginbttn.getAttribute("class"));

        //getText vs getAttribute


    }
}
