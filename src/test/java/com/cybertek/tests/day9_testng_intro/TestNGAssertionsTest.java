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
        String actual = "one";

        Assert.assertTrue(expected.equals(actual));

        int e =100;
        int a = 200;
        Assert.assertTrue(a>e);
    }


    @Test
    public void test5(){
        // verify that url is EQUAL to https://www.google.com/

        String expected = "https://www.google.com/";
        String actual = "https://www.google.com/";
        Assert.assertEquals(expected, actual);

        // verify that title starts with java
        String expected1 = "java";
        String actual1 = "java - Google Search";

        Assert.assertTrue(actual1.startsWith(expected1));

    }


    @Test
    public void fromHamid (){
        int a =100;
        int b = 200;
        Assert.assertTrue(b>a); // this line is true but
        Assert.assertTrue(a>b); /// false
    }

}
