package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PageHeadersTests extends VytrackTestBase {
    // go to vyrack
    // login as driver
    // verify  header is "Quick Launchpad"

    @Test
    public void dashboardPageTest(){

        test = report.createTest("Dashboard page title test");

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        loginPage.login(username, password);

        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, "Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        test.info("Verifying page header text");
        assertEquals(actual, "Quick Launchpad");
        test.pass("PASS: Dashboard page title test");

    }


//    go to vyrack
    // go to Fleet vehicles
    // login as driver
    // verify  header is "Cars"

    @Test
    public void fleetVehiclesTest() throws InterruptedException {
        test = report.createTest("Vehicles page title test");

        // use login to login
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        test.info("Username: " + username);
        test.info("Password: " + password);
        loginPage.login(username, password);
        // use dashbaord change page

        test.info("Going to Fleet -> Vehicles");
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();

        // use the fllet / vehicles page to get text
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Cars"));
        test.info("Verifying page header");
        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Carros");
        test.pass("PASS: Vehicles page title test");

    }


}
