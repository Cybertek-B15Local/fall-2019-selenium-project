package com.cybertek.tests.office_hours4;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertNotEquals;

public class ChangeMenuSoftAssertTest extends VytrackTestBase {
    // go to vyrack
    //verify we are logged in
    // change menu to vehicles and verify title
    // change menu to customers and verify title

    @Test
    public void testMenuOptions() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        assertNotEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login", "URL did not match");

        dashboardPage.changeMenu("Fleet", "Vehicles");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("my Jeep car"), "Vehicles page title did not match");

        dashboardPage.changeMenu("Customers", "Accounts");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("Accounts"), "Accounts page title did not match");

    }
}
