package com.cybertek.tests.day9_testng_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\tBEFORE METHOD");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("\tAFTER METHOD");
    }

    @Test
    public void test1(){
        System.out.println("this is test one");
//        Assert.assertEquals(true, false);
    }


    @Test
    public void test2(){
        System.out.println("this is test two");
    }


}
