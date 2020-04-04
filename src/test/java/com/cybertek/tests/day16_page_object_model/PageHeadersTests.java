package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.pages.DashboardPage;
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
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username, password);

        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHader, "Quick Launchpad"));
        String actual = dashboardPage.pageHader.getText();
        assertEquals(actual, "Quick Launchpad");

    }


//    go to vyrack
    // go to Fleet vehicles
    // login as driver
    // verify  header is "Cars"

    @Test
    public void fleetVehiclesTest() throws InterruptedException {

        // use login to login
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username, password);
        // use dashbaord change page
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();

        // use the fllet / vehicles page to get text
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHader, "Cars"));
        String actual = vehiclesPage.pageHader.getText();
        assertEquals(actual, "Cars");
    }


}
