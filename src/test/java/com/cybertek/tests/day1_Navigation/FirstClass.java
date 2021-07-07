package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FirstClass {

    public static void main(String[] args) throws InterruptedException {

        //Old way to get a driver
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\alfre\\seleniumdrivers\\chromedriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //get() vs navigate().to(): wait vs doesn't wait for the page to load
        driver.get("https://www.google.com");
    //    driver.navigate().to("https://www.google.com");
       /*
       Navigation:
       driver.navigate().to("URL")
       driver.navigate().back()
       driver.navigate().forward()
       driver.navigate().refresh()
        */

       /*
        driver.get()
        driver.findElements()
        driver.findElement()
        driver.navigate()
        driver.getTitle()
        driver.quit()
        driver.switchTo()
        driver.getWindowHandles()
        driver.getWindowHandle()
        driver.getPageSource()
        driver.getCurrentUrl()
        driver.manage()
        driver.close()
        */
    }

}
