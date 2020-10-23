package com.cybertek.tests.day14_test_base_props_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SingletonDriver {

    private static SingletonDriver singletonDriver = null;
    private WebDriver driver;

    private SingletonDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alfre\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("An instance of WebDriver has been created");
    }

    public static SingletonDriver getSingletonDriver(){
        if (singletonDriver == null){
            singletonDriver = new SingletonDriver();
        }
        //Otherwise return the existing singletonDriver
        return singletonDriver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    @Test
    public void singletonTest2(){
        //Two instance of the class but both give the same instance of the driver.
        SingletonDriver sDriver1 = SingletonDriver.getSingletonDriver();
        WebDriver driver1 = sDriver1.getDriver();

        SingletonDriver sDriver2 = SingletonDriver.getSingletonDriver();
        WebDriver driver2 = sDriver2.getDriver();
    }
}