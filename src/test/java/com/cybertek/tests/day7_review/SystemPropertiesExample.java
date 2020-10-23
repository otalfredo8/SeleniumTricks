package com.cybertek.tests.day7_review;

public class SystemPropertiesExample {

    public static void main(String[] args) {
        //TOASK Why is important to know the System class?
        String property = System.getProperty("os.name");

        System.out.println(property);

        System.out.println("OS: " + System.getProperty("os.name") + "; Version: " + System.getProperty("os.version"));

        System.out.println(System.getProperty("user.dir"));
    }
}
