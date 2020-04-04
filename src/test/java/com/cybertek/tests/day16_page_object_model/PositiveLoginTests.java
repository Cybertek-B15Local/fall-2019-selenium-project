package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpTests() {
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();

    }

    @Test
    public void loginAsDrivers(){
        loginPage.logIn
    }

}
