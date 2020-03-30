package com.cybertek.tests.office_hours3;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EtsyTests extends TestBase {
    /*
    search for wooden spoon on etsy
    verify that default shipt to location is Ship to
    verify Ship to countries include Australia
     */

    @Test
    public void verifyCountryList(){
        driver.get("https://etsy.com");

    }
}
