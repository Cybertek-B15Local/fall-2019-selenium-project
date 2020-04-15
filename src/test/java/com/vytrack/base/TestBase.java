package com.vytrack.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    static protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;
    protected Pages pages;

    @Parameters({"env", "browser"})
    @BeforeSuite
    public void setUpSuite(@Optional String env, @Optional String browser) {
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }


    @AfterSuite
    public void tearDownSuite() {
        report.flush();
    }

    @Parameters({"env", "browser"})
    @BeforeMethod()
    public void setUpMethod(@Optional String env, @Optional String browser) {
        driver = Driver.getDriver(browser);
        pages = new Pages();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (env == null) {
            env = ConfigurationReader.getProperty("env");
        }
        String url = ConfigurationReader.getProperty(env + "_url");
        driver.get(url);

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws IOException {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            test.fail(iTestResult.getName());
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshot);
            test.fail(iTestResult.getThrowable());
        }
        Driver.closeDriver();

    }
}
