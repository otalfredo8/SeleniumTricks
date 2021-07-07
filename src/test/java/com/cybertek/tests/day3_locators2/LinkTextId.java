package com.cybertek.tests.day3_locators2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextId {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
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
