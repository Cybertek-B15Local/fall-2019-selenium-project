package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {

    public static void main(String[] args) {

        /*
        go to forgot password page'
        locate retrive password bttn

        print out submit value
                   type='submit'
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement retreivePasswrodBttn = driver.findElement(By.id("form_submit"));


    //  <button id="form_submit" class="radius" type="submit"><i class="icon-2x icon-signin">Retrieve password</i></button>

        System.out.println(retreivePasswrodBttn.getAttribute("type"));  //submit

        System.out.println(retreivePasswrodBttn.getAttribute("class"));  //readuis

        System.out.println(retreivePasswrodBttn.getAttribute("id"));   //for_submit




    }
}
