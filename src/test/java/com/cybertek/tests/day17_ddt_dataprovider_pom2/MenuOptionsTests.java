package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class MenuOptionsTests extends VytrackTestBase {


    @Test
    public void test(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        dashboardPage.changeMenu("Activities", "Calendar Events");

    }
}
