package com.cybertek.tests.day14_test_base_props_driver;

public class Singleton {

    //string will only be instantiated once
    private static String string;

    // make constructor private
    private Singleton() {
    }

    public static String getInstance() {
        if (string == null) {
            string = "chrome";
        }
        return string;
    }
}
