package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlertsExamples {


    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void htmlPopup() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        WebElement button = driver.findElement(By.xpath("//span[text()='Destroy the World']"));
        button.click();

        Thread.sleep(1000);
        WebElement noooo = driver.findElement(By.xpath("//span[.='No']"));
        noooo.click();
        Thread.sleep(1000);
    }
}
