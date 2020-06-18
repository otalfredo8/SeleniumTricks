package com.cybertek.tests.day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstClass {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //get() vs navigate().to(): wait vs doesn't wait
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
