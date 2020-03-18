package com.cybertek.tests.day9_testng_intro;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\tBEFORE METHOD");
    }

    @Test
    public void test1(){
        System.out.println("this is test one");
    }

    @Test
    public void test2(){
        System.out.println("this is test two");
    }

}
