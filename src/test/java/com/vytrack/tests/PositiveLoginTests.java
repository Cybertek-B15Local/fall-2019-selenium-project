package com.vytrack.tests;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PositiveLoginTests extends TestBase {

    @Test
    public void loginAsDrivers() {
        test = report.createTest("Login as Driver");
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in as a driver");
        test.info("Username: " + username);
        test.info("Password: " + password);
        pages.getLoginPage().login(username, password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String expected = "Dashboard";
        test.info("Verify title. Expected: " + expected);
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expected);
        test.pass("Pass: Login as Driver");

    }

    @Test
    public void loginAsSalesManger() {
        test = report.createTest("Login as Sales manager");
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");
        test.info("Logging in as a driver");
        test.info("Username: " + username);
        test.info("Password: " + password);
        pages.getLoginPage().login(username, password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String expected = "Dashboard";
        test.info("Verify title. Expected: " + expected);
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expected);
        test.pass("Pass: Login as Sales manager");

    }

    @Test
    public void loginAsStoreManager() {
        test = report.createTest("Login as Store manager");
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");
        test.info("Logging in as a driver");
        test.info("Username: " + username);
        test.info("Password: " + password);
        pages.getLoginPage().login(username, password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String expected = "Dashboard";
        test.info("Verify title. Expected: " + expected);
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expected);
        test.pass("Pass: Login as Sote manager");

    }


}
