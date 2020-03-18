package com.cybertek.tests.day9_testng_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsTest {

    @Test
    public void test1(){
        String expected = "one";
        String actual = "one";

        Assert.assertEquals(actual, expected);
        Assert.assertEquals(1, 1);
        Assert.assertEquals(true, true);

        System.out.println("test 1 complete");

    }

    @Test
    public void test2(){
        String expected = "one";
        String actual = "two";

        System.out.println("starting to compare");

        Assert.assertEquals(actual, expected);

        System.out.println("test 2 complete");
    }

    @Test
    public void test3(){
        String expected = "one";
        String actual = "two";
        Assert.assertNotEquals(expected, actual);
        Assert.assertNotEquals(1, 2);

    }

    @Test
    public void test4(){
        String expected = "one";
        String actual = "two";

//        Assert.assertTrue();
    }

}
