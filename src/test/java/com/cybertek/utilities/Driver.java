package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public WebDriver getDriver(){

        return driver;
    }
}
