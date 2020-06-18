package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClicikvsSubmit {

    public static void main(String[] args) {
        /*
        Click() va Submit()
        .click() has to be done on the type="submit" button.
        .submit() can be done on any type element.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to forgot password web page
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        // enter any email
        WebElement emailbox = driver.findElement(By.name("email"));
        emailbox.sendKeys("abc@gamil.com");

        WebElement submitBttn = driver.findElement(By.id("form_submit"));
        submitBttn.submit();

      //    Verify  --> Expected result  vs Actual result

        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("test is pass");
        }else {
            System.out.println("test is failed");
        }
    driver.close();
    }
}
