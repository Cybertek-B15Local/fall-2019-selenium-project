package com.cybertek.tests.day9_testng_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsTest {

    @Test
    public void test1(){
        String expected = "one";
        String actual = "one";

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void test2(){
        String expected = "one";
        String actual = "two";

        Assert.assertEquals(actual, expected);

    }
}
