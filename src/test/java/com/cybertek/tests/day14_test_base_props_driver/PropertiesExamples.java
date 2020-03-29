package com.cybertek.tests.day14_test_base_props_driver;

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


    }
}
