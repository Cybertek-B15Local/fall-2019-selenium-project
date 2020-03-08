package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {

    /*
    go to login page
    enter username
    enter password
    click login button

    Verift the welcome massage "Welcome to the Secure Area. When you are done click logout below."
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();

        //locating the welcome massage with tagname

        WebElement welcomeMassage = driver.findElement(By.tagName("h4"));

      //  Verify the welcome massage
        //expected vs actual
        String expectedMassage = "Welcome to the Secure Area. When you are done click logout below.";

        // String vs WebElement
        //getText() --> convert webElement to String
        //
        String actualWelcomeMassage = welcomeMassage.getText();

        if (expectedMassage.equalsIgnoreCase(actualWelcomeMassage)){
            System.out.println("PASSS");
        }else {
            System.out.println("Fail");
        }

//        driver.close();




    }




}
