package com.cybertek.tests.day5_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("headless_chrome");
        driver.get("http://practice.cybertekschool.com/login");

        WebElement link = driver.findElement(By.linkText("Home"));
        System.out.println(link.getText());

        WebElement loginBtn = driver.findElement(By.id("wooden_spoon"));
        System.out.println(loginBtn.getText());

//         class name does not work if the value of the class attribute has a space
//        WebElement loginBtn = driver.findElement(By.className("btn btn-primary"));
//        loginBtn.click();

    }
}
