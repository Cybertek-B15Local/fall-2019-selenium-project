package com.cybertek.base;

import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehiclesPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class VytrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclesPage vehiclesPage;
    protected CreateCalendarEventsPage createCalendarEventsPage;


    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        vehiclesPage = new VehiclesPage();
        createCalendarEventsPage = new CreateCalendarEventsPage();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        softAssert.assertAll();
//        Thread.sleep(3000);
        Driver.closeDriver();
    }

}
