package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.time.ZonedDateTime;

public class AmazonCssExample {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("headless_firefox");
        driver.get("https://amazon.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 9);
        wait.until(ExpectedConditions.elementToBeClickable
                ((By.xpath("//a[@href='/gp/goldbox?ref_=nav_cs_gb']")))).click();

        String expected = "Today's Deals";
        WebElement topHeader = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".nav-a-content")));
        System.out.println(topHeader.getText());

        if (expected.equals(topHeader.getText())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual " + topHeader.getText());
        }

        WebElement bottomHeader = driver.findElement(By.cssSelector("h1>div:nth-of-type(1)"));
        System.out.println(bottomHeader.getText());

        if (expected.equals(bottomHeader.getText())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + bottomHeader.getText());
        }

        driver.close();

    }
}
