package com.cybertek.tests.day14_test_base_props_driver;

public class Singleton {
    // make constructor private
    private Singleton() {
    }

    static String string = "my string";

    public static String getInstance() {
        return string;
    }
}
