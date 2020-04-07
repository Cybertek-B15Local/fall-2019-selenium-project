package com.cybertek.tests.day18_html_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import org.testng.annotations.BeforeMethod;

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
        // + "test-output/report.html" --> create folder test-output and in it create file report.html
        String path = System.getProperty("user.dir")+"test-output/report.html";
        // initialize the html reporter with the given path
        htmlReporter = new ExtentHtmlReporter(path);
        // set name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        // set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", "Chrome");


    }
}
