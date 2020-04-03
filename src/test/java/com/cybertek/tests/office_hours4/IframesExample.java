package com.cybertek.tests.office_hours4;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IframesExample extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.tagName("h2")).getText());

    }
}
