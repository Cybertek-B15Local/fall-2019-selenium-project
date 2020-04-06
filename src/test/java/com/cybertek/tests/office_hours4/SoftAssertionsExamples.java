package com.cybertek.tests.office_hours4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExamples {

    @Test
    public void test(){

        Assert.assertEquals(11, 1, "first assertion failed");

        Assert.assertEquals(2, 2, "second assertion failed");

    }

    @Test
    public void test2(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(11, 1, "first assertion failed");
        softAssert.assertEquals(1, 1, "second assertion failed");
        softAssert.assertEquals(22, 2, "third assertion failed");

        softAssert.assertAll();
    }


}

