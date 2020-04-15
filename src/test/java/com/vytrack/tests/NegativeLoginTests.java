package com.vytrack.tests;

import com.vytrack.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {
    private String message="Invalid user name or password.";

    @Test
    public void wrongUsernameTest() {
        test = report.createTest("Wrong username test");
        test.info("open login page");
        test.info("Username: user30000");
        test.info("Password: UserUser123");
        pages.getLoginPage().username.sendKeys("user30000");
        pages.getLoginPage().password.sendKeys("UserUser123");
        pages.getLoginPage().logIn.click();

        String actual = pages.getLoginPage().errorMessage.getText();
        test.info("Verify error message: "+ message);
        Assert.assertTrue(pages.getLoginPage().errorMessage.isDisplayed());
        Assert.assertEquals(actual, message);
        test.pass("PASS: Wrong username test");
    }

    @Test
    public void wrongPasswordTest() {
        test = report.createTest("Wrong password test");
        test.info("open login page");
        test.info("Username: user30000");
        test.info("Password: asfasfafsa");
        pages.getLoginPage().username.sendKeys("SalesManager110");
        pages.getLoginPage().password.sendKeys("asfasfafsa");
        pages.getLoginPage().logIn.click();

        String actual = pages.getLoginPage().errorMessage.getText();
        test.info("Verify error message: "+ message);
        Assert.assertTrue(pages.getLoginPage().errorMessage.isDisplayed());
        Assert.assertEquals(actual, message);
        test.pass("PASS: Wrong password test");

    }

}
