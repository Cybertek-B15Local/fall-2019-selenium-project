package com.vytrack.tests;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PageHeadersTests extends TestBase {


    @Test
    public void dashboardPageTest(){

        test = report.createTest("Dashboard page title test");

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        pages.getLoginPage().login(username, password);

        wait.until(ExpectedConditions.textToBePresentInElement(pages.getDashboardPage().pageHeader, "Quick Launchpad"));
        String actual = pages.getDashboardPage().pageHeader.getText();
        test.info("Verifying page header text");
        assertEquals(actual, "Quick Launchpad");
        test.pass("PASS: Dashboard page title test");

    }


    @Test
    public void fleetVehiclesTest() throws InterruptedException {
        test = report.createTest("Vehicles page title test");
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        test.info("Username: " + username);
        test.info("Password: " + password);
        pages.getLoginPage().login(username, password);
        test.info("Going to Fleet -> Vehicles");
        pages.getDashboardPage().changeMenu("Fleet", "Vehicles");
        wait.until(ExpectedConditions.textToBePresentInElement(pages.getDashboardPage().pageHeader, "Cars"));
        test.info("Verifying page header");
        String actual = pages.getVehiclesPage().pageHeader.getText();
        assertEquals(actual, "Cars");
        test.pass("PASS: Vehicles page title test");

    }


    @Test
    public void customersContacts() throws InterruptedException {
        test = report.createTest("Contacts page title test");
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        test.info("Username: " + username);
        test.info("Password: " + password);
        pages.getLoginPage().login(username, password);
        test.info("Going to Customer -> Contacts");
        pages.getDashboardPage().changeMenu("Customers", "Contacts");
        wait.until(ExpectedConditions.textToBePresentInElement(pages.getDashboardPage().pageHeader, "Contacts"));
        test.info("Verifying page header");
        String actual = pages.getDashboardPage().pageHeader.getText();
        assertEquals(actual, "Cars");
        test.pass("PASS: Contacts page title test");


    }
}
