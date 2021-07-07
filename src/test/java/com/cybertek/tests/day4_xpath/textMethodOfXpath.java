package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class textMethodOfXpath {

    public static void main(String[] args) {
        /*
        go to http://practice.cybertekschool.com/context_menu
        verify  Context Menu  is on the page

        //tagName[text()='exact Text']
        //tagName[contains(text(),'partial Text')]
         */

        WebDriver driver = WebDriverFactory.getDriver("headless_chrome");
        driver.get("http://practice.cybertekschool.com/context_menu");

        //locate the element Context Menu

//        WebElement text = driver.findElement(By.xpath("//h3[text()='Context Menu']"));
        WebElement text = driver.findElement(By.xpath("//h3[contains(text(),'Context')]"));

        //Verify --> expect vs actual

        String expectedText = "Context Menu";
        String actualText = text.getText();

        if(expectedText.equals(actualText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        driver.close();
    }
}
