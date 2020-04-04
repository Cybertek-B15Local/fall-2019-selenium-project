package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {

    @Test
    public void wrongUsernameTest(){
        driver.get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys("user30000");
        loginPage.password.sendKeys("UserUser123");
        loginPage.logIn.click();

        String actual = loginPage.errorMessage.getText();

        Assert.assertEquals(actual, "Invalid user name or password.");
    }


}
