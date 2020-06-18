package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    /*which can be used for static initializations of a class.
    This code inside static block is executed only once:
     the first time you make an object of that class or
     the first time you access a static member of that class
     (even if you never make an object of that class)
     */
    static {

        try {
            // reads file in java. we neeed to pass the path of the file
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            // load contents of the file the properties object.
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}
