package com.cybertek.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehiclesPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public abstract class VytrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclesPage vehiclesPage;
    protected CreateCalendarEventsPage createCalendarEventsPage;

    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpSuite(){
        report = new ExtentReports();
        String path = System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));

    }

    @AfterSuite
    public void tearDownSuite(){
        report.flush();
    }

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
//        Thread.sleep(3000);
        Driver.closeDriver();
        softAssert.assertAll();
    }

}
