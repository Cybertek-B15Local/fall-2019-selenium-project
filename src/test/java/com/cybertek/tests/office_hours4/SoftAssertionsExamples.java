package com.cybertek.tests.office_hours4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExamples {

    @Test
    public void test() {

        Assert.assertEquals(11, 1, "first assertion failed");

        Assert.assertEquals(2, 2, "second assertion failed");

    }

    @Test
    public void test2() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(11, 1, "first assertion failed");
        softAssert.assertEquals(1, 1, "second assertion failed");
        softAssert.assertEquals(22, 2, "third assertion failed");

        softAssert.assertAll();
    }

    @Test
    public void test3() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(true, "first assertion");
        System.out.println("first assertion done");

        Assert.assertTrue(true, "second assertion");
        System.out.println("second assertion done");

        Assert.assertTrue(true, "third assertion");
        System.out.println("third assertion done");

        softAssert.assertTrue(true, "fourth assertion");
        System.out.println("fourth assertion done");

        // report all of the soft asserts, if any of the soft asserts ever failed, throws assertion error
        softAssert.assertAll();

        Assert.assertTrue(true, "fifth assertion");
        System.out.println("fifth assertion done");

    }


}

