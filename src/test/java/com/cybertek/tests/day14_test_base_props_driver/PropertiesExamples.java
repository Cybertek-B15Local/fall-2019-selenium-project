package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesExamples {

    @Test
    public void test(){

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));

        // browser url
        // Properties --> class from java that saves key value combinations
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        properties.setProperty("url", "http://practice.cybertekschool.com");

        String browser = properties.getProperty("browser");
        System.out.println("browser name= " + browser);

        // i need the browser/url from properties file

        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser =" + pBrowser);

        String pUrl = ConfigurationReader.getProperty("url");

        System.out.println("pUrl = " + pUrl);


    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // get the the from props file
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.close();
        String str = Singleton.getInstance().toUpperCase();
        System.out.println(str);
    }

    @Test
    public void test3(){
        String str = Singleton.getInstance();
        System.out.println(str);
    }

}
