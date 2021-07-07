package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.lang.ref.PhantomReference;

public class WebDriverFactory {

    //write a static return method which returns WebDriver
    //name : getDriver
    //it takes a String as a parameter  --> browser type
    //returns ChromeDriver and FirefoxDriver

    public static WebDriver getDriver(String browserType){
        //local veriables
        WebDriver driver = null;

        switch (browserType.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                //break;    //TOASK - what is the  fuction of the break statement?
            case "headless_chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
            case "headless_firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
        }
        return driver;
    }


}
