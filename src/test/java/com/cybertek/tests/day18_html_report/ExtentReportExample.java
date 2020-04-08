package com.cybertek.tests.day18_html_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportExample {

    // used to set up a new report and build the reports
    ExtentReports report;

    // used to create the html report
    ExtentHtmlReporter htmlReporter;

    // used to define a test in report, do logging, mark test results
    ExtentTest test;

    @BeforeMethod
    public void setUp(){
        // initialize the report
        report = new ExtentReports();

        // i need to point to the location where report will be create
        // System.getProperty("user.dir") --> gets my current folder
        // + "/test-output/report.html" --> create folder test-output and in it create file report.html
        String path = System.getProperty("user.dir")+"/test-output/report.html";
        // initialize the html reporter with the given path
        htmlReporter = new ExtentHtmlReporter(path);

        // set name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        // attach the html reporter to the report object
        report.attachReporter(htmlReporter);

        // set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", "Chrome");

    }

    @Test
    public void test(){
        // we have to create a test for every test case
        test = report.createTest("VYT-123 Title verification test");
        test.info("Opening browser");
        // driver = new Chromedriver
        test.info("going to website");
        // driver.get(goole.com)
        test.info("verifying title");
        // assertEquals(google, google)
        test.pass("VYT-123 Title verification test");

    }

    @AfterMethod
    public void tearDown(){
        // the report will be created when we call this line.
        // if we dont call flush method it will not be generated.
        // we do this at the end of everything.
        report.flush();
    }



}
