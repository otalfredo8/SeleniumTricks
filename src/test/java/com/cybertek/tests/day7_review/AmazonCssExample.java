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

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 9);
        wait.until(ExpectedConditions.elementToBeClickable
                ((By.xpath("//a[contains(@href,'/gp/goldbox')]")))).click();

        //https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb_40dff72b654a4d9e977a0d06d9b4038f

        String expected = "Today's Deals";
        WebElement topHeader = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[contains(text(),'New deals')]//preceding-sibling::h1[contains(text(),'Today')]")));
        System.out.println(topHeader.getText());

        if (expected.equals(topHeader.getText())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual " + topHeader.getText());
        }

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("nav-progressive-subnav"))));
        WebElement firstCarouselItem  = driver.findElement(By.xpath("//*[@aria-label='Shop collections']//descendant::span[text()='All Deals']"));
        System.out.println(firstCarouselItem.getText());

        String expectedCarouselItem = "All Deals";
        if (expectedCarouselItem.equals(firstCarouselItem.getText())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expectedCarouselItem);
            System.out.println("actual = " + firstCarouselItem.getText());
        }

        driver.close();

    }
}
