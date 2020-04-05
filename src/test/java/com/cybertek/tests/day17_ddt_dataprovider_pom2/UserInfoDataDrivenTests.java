package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInfoDataDrivenTests {

    @Test(dataProvider = "users")
    public void test(String username, String password) {
        System.out.println("opening application");
        System.out.println("login as: " + username);
        System.out.println("verify info");
    }



    @DataProvider(name = "users")
    public Object[][] getUsers() {
        return new Object[][]
                {
                        {"user1", "UserUser123"},
                };
    }


}
